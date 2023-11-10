package com.example.search

import com.example.domain.models.ProductsResponse

sealed interface ProductsUiState {
    object Loading: ProductsUiState
    data class Success (val products: List<ProductsResponse>): ProductsUiState
    data class Error (val throwable: Throwable): ProductsUiState
}

data class MainProductsUiState(
    val response: ProductsUiState
)