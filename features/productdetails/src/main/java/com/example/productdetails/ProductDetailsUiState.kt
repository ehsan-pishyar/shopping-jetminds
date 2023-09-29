package com.example.productdetails

import com.example.domain.models.ProductsResponse

sealed interface ProductDetailsUiState {
    object Loading: ProductDetailsUiState
    data class Success(val productDetails: ProductsResponse): ProductDetailsUiState
    data class Error(val throwable: Throwable): ProductDetailsUiState
}

data class MainProductDetailsUiState(
    val productDetailsUiState: ProductDetailsUiState
)