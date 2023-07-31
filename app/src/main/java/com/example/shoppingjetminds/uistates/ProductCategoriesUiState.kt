package com.example.shoppingjetminds.uistates

import com.example.domain.models.ProductCategoriesResponse

sealed interface ProductCategoriesUiState {
    object Loading: ProductCategoriesUiState
    data class Success(val categories: List<ProductCategoriesResponse>): ProductCategoriesUiState
    data class Error(val message: String): ProductCategoriesUiState
}

sealed interface ProductCategoryDetailsUiState {
    object Loading: ProductCategoryDetailsUiState
    data class Success(val categoryDetails: ProductCategoriesResponse): ProductCategoryDetailsUiState
    data class Error(val message: String): ProductCategoryDetailsUiState
}

data class MainProductCategoriesUiState(
    val categoriesUiState: ProductCategoriesUiState
)

data class MainProductCategoryDetailsUiState(
    val categoryDetailsUiState: ProductCategoryDetailsUiState
)