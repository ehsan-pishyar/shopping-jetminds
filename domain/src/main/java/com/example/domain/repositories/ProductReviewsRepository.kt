package com.example.domain.repositories

import com.example.domain.models.ProductReviewsResponse
import kotlinx.coroutines.flow.Flow

interface ProductReviewsRepository {

    fun getProductReviews(productId: Int): Flow<List<ProductReviewsResponse>>
    fun getProductReviewDetails(reviewId: Int): Flow<ProductReviewsResponse>
    suspend fun refreshProductReviews()
}