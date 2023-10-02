package com.example.productdetails.uistate

import com.example.domain.models.ProductReviewsResponse

sealed interface ProductReviewsUiState {
    object Loading: ProductReviewsUiState
    data class Success(val reviews: List<ProductReviewsResponse>): ProductReviewsUiState
    data class Error(val message: String): ProductReviewsUiState
}

data class MainProductReviewsUiState(
    val reviewsUiState: ProductReviewsUiState
)