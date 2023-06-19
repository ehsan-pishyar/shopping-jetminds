package com.example.shoppingjetminds.viewmodels

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ProductsResponse
import com.example.domain.use_cases.products.GetProductsByCategoryIdUseCase
import com.example.domain.utils.Result
import com.example.shoppingjetminds.utils.WhileUiSubscribed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsByCategoryIdUseCase: GetProductsByCategoryIdUseCase
): ViewModel() {

    private val isRefreshing = MutableStateFlow(false)
    private val isError = MutableStateFlow(false)

    private val ui8ProductsUiState = getProductsByCategoryIdUseCase.invoke(115)
    private val otherProductsUiState = getProductsByCategoryIdUseCase.invoke(120)
    private val androidProductsUiState = getProductsByCategoryIdUseCase.invoke(111)

    val homeUiState: StateFlow<HomeUiState> = combine(
        ui8ProductsUiState,
        otherProductsUiState,
        androidProductsUiState,
        isRefreshing,
        isError
    ) { ui8State, otherState, androidState, refreshing, error ->
        val ui8: Ui8ProductsUiState = when (ui8State) {
            is Result.Loading -> Ui8ProductsUiState.Loading
            is Result.Success -> Ui8ProductsUiState.Success(data = ui8State.data)
            is Result.Error -> Ui8ProductsUiState.Error(throwable = ui8State.throwable?.cause)
        }
        val other: OtherProductsUiState = when (otherState) {
            is Result.Loading -> OtherProductsUiState.Loading
            is Result.Success -> OtherProductsUiState.Success(data = otherState.data)
            is Result.Error -> OtherProductsUiState.Error(throwable = otherState.throwable?.cause)
        }
        val android: AndroidProductsUiState = when (androidState) {
            is Result.Loading -> AndroidProductsUiState.Loading
            is Result.Success -> AndroidProductsUiState.Success(data = androidState.data)
            is Result.Error -> AndroidProductsUiState.Error(throwable = androidState.throwable?.cause)
        }

        HomeUiState(
            ui8,
            other,
            android,
            refreshing,
            error
        )
    }.stateIn(
        scope = viewModelScope,
        started = WhileUiSubscribed,
        initialValue = HomeUiState(
            Ui8ProductsUiState.Loading,
            OtherProductsUiState.Loading,
            AndroidProductsUiState.Loading,
            isRefreshing = false,
            isError = false
        )
    )

    fun onRefresh() {
        viewModelScope.launch {

        }
    }

    fun onErrorConsumed() {
        viewModelScope.launch {
            isError.emit(false)
        }
    }
}

data class HomeUiState(
    val ui8ProductsUiState: Ui8ProductsUiState,
    val otherProductsUiState: OtherProductsUiState,
    val androidProductsUiState: AndroidProductsUiState,
    val isRefreshing: Boolean,
    val isError: Boolean
)

@Immutable
sealed interface Ui8ProductsUiState {
    data class Success(val data: List<ProductsResponse>): Ui8ProductsUiState
    data class Error(val throwable: Throwable? = null): Ui8ProductsUiState
    object Loading: Ui8ProductsUiState
}

@Immutable
sealed interface OtherProductsUiState {
    data class Success(val data: List<ProductsResponse>): OtherProductsUiState
    data class Error(val throwable: Throwable? = null): OtherProductsUiState
    object Loading: OtherProductsUiState
}

@Immutable
sealed interface AndroidProductsUiState {
    data class Success(val data: List<ProductsResponse>): AndroidProductsUiState
    data class Error(val throwable: Throwable? = null): AndroidProductsUiState
    object Loading: AndroidProductsUiState
}