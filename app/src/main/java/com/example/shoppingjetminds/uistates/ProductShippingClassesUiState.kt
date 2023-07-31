package com.example.shoppingjetminds.uistates

import com.example.domain.models.ProductShippingClassesResponse

sealed interface ProductShippingClassesUiState {
    object Loading: ProductShippingClassesUiState
    data class Success(val shippingClasses: List<ProductShippingClassesResponse>): ProductShippingClassesUiState
    data class Error(val message: String): ProductShippingClassesUiState
}

data class MainProductShippingClassesUiState(
    val shippingClassesUiState: ProductShippingClassesUiState
)