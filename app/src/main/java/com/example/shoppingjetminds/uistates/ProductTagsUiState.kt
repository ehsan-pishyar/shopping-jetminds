package com.example.shoppingjetminds.uistates

import com.example.domain.models.ProductTagsResponse

sealed interface ProductTagsUiState {
    object Loading: ProductTagsUiState
    data class Success(val tags: List<ProductTagsResponse>): ProductTagsUiState
    data class Error(val message: String): ProductTagsUiState
}

sealed interface ProductTagDetailsUiState {
    object Loading: ProductTagDetailsUiState
    data class Success(val tagDetails: ProductTagsResponse): ProductTagDetailsUiState
    data class Error(val message: String): ProductTagDetailsUiState
}

data class MainProductTagsUiState(
    val tagsUiState: ProductTagsUiState
)

data class MainProductTagDetailsUiState(
    val tagDetailsUiState: ProductTagDetailsUiState
)