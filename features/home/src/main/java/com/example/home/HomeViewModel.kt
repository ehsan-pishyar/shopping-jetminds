package com.example.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.utils.Categories
import com.example.core.utils.WhileUiSubscribed
import com.example.domain.use_cases.cart.UpdateCartItemUseCase
import com.example.domain.use_cases.favorites.IsFavoriteProductUseCase
import com.example.domain.use_cases.products.GetProductsUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getApplicationUiKitUseCase: GetProductsUseCase,
    getAndroidUseCase: GetProductsUseCase,
    getIllustrations3DUseCase: GetProductsUseCase,
    private val updateCartItemUseCase: UpdateCartItemUseCase,
    private val isFavoriteProductUseCase: IsFavoriteProductUseCase
): ViewModel() {

    private val isRefreshing = MutableStateFlow(false)
    private val isError = MutableStateFlow(false)

    private var _isFavoriteState = MutableStateFlow(false)
    val isFavoriteState = _isFavoriteState.asStateFlow()

    val homeUiState: StateFlow<HomeUiState> = combine(
        getApplicationUiKitUseCase.invoke(categoryId = Categories.APPLICATION_UI_KIT.id),
        getAndroidUseCase.invoke(categoryId = Categories.ANDROID.id),
        getIllustrations3DUseCase.invoke(categoryId = Categories.ILLUSTRATIONS_3D.id),
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

    fun updateCart(productId: Int, inCart: Boolean, addedToCartDate: String) {
        viewModelScope.launch {
            updateCartItemUseCase.invoke(
                productId = productId,
                inCart = inCart,
                addedToCartDate = addedToCartDate
            )
        }
    }

    fun onErrorConsumed() {
        viewModelScope.launch {
            isError.emit(false)
        }
    }
}

