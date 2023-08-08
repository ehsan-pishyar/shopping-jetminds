package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.products.GetProductsByCategoryIdUseCase
import com.example.domain.use_cases.products.GetProductsUseCase
import com.example.domain.utils.ServiceResult
import com.example.shoppingjetminds.uistates.AndroidUiState
import com.example.shoppingjetminds.uistates.ApplicationUiKitUiState
import com.example.shoppingjetminds.uistates.HomeUiState
import com.example.shoppingjetminds.uistates.Illustrations3DUiState
import com.example.shoppingjetminds.utils.Categories
import com.example.shoppingjetminds.utils.WhileUiSubscribed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getApplicationUiKitUseCase: GetProductsUseCase,
    getAndroidUseCase: GetProductsUseCase,
    getIllustrations3DUseCase: GetProductsUseCase
): ViewModel() {

    private val isRefreshing = MutableStateFlow(false)
    private val isError = MutableStateFlow(false)

    val homeUiState: StateFlow<HomeUiState> = combine(
        getApplicationUiKitUseCase.invoke(Categories.APPLICATION_UI_KIT.id),
        getAndroidUseCase.invoke(Categories.ANDROID.id),
        getIllustrations3DUseCase.invoke(Categories.ILLUSTRATIONS_3D.id),
        isRefreshing,
        isError
    ) { applicationUiKitUiState, androidUiState, illustrations3DUiState, refreshing, errorConsumed ->

        val applicationUiKit: ApplicationUiKitUiState = when (applicationUiKitUiState) {
            ServiceResult.Loading -> ApplicationUiKitUiState.Loading
            is ServiceResult.Success -> ApplicationUiKitUiState.Success(
                applicationUiKits = applicationUiKitUiState.data
            )
            is ServiceResult.Error -> ApplicationUiKitUiState.Error(
                message = applicationUiKitUiState.throwable
            )
        }

        val androidSourceCodes: AndroidUiState = when (androidUiState) {
            ServiceResult.Loading -> AndroidUiState.Loading
            is ServiceResult.Success -> AndroidUiState.Success(
                androidSourceCodes = androidUiState.data
            )
            is ServiceResult.Error -> AndroidUiState.Error(
                message = androidUiState.throwable
            )
        }

        val illustration3Ds: Illustrations3DUiState = when (illustrations3DUiState) {
            ServiceResult.Loading -> Illustrations3DUiState.Loading
            is ServiceResult.Success -> Illustrations3DUiState.Success(
                illustration3Ds = illustrations3DUiState.data
            )
            is ServiceResult.Error -> Illustrations3DUiState.Error(
                message = illustrations3DUiState.throwable
            )
        }

        HomeUiState(
            applicationUiKit,
            androidSourceCodes,
            illustration3Ds,
            refreshing,
            errorConsumed
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = WhileUiSubscribed,
            initialValue = HomeUiState(
                ApplicationUiKitUiState.Loading,
                AndroidUiState.Loading,
                Illustrations3DUiState.Loading,
                isRefreshing = false,
                isError = false
            )
        )

    fun onErrorConsumed() {
        viewModelScope.launch {
            isError.emit(false)
        }
    }
}

