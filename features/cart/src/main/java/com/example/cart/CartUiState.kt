package com.example.cart

import com.example.domain.models.ProductsResponse

sealed interface CartUiState {
    object Loading: CartUiState
    data class Success(val items: List<ProductsResponse>): CartUiState
    data class Error(val throwable: Throwable): CartUiState
}

data class MainCartUiState(
    val cartUiState: CartUiState
)