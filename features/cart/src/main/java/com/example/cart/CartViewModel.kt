package com.example.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ProductsResponse
import com.example.domain.use_cases.products.GetProductsUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
): ViewModel() {

    private var _cartUiState = MutableStateFlow(MainCartUiState(CartUiState.Loading))
    val cartUiState = _cartUiState.asStateFlow()

    private var _hasItem = MutableStateFlow(false)
    val hasItem = _hasItem.asStateFlow()

    init {
        getItems()
    }

    private fun getItems() {
        viewModelScope.launch {
            getProductsUseCase.invoke().collect { productsResult ->
                val cartUiStateResult = when (productsResult) {
                    ServiceResult.Loading -> CartUiState.Loading
                    is ServiceResult.Success -> CartUiState.Success(
                        items = productsResult.data
                    )
                    is ServiceResult.Error -> CartUiState.Error(
                        throwable = productsResult.throwable!!
                    )
                }
                _cartUiState.value = MainCartUiState(
                    cartUiState = cartUiStateResult
                )
            }
        }
    }

    fun saveItem(product: ProductsResponse) {
        viewModelScope.launch {

        }
    }
}