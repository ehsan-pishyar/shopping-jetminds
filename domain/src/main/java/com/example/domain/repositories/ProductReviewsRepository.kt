package com.example.domain.repositories

import com.example.domain.models.ProductReviewsResponse
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface ProductReviewsRepository {

    fun getProductReviews(): Flow<ServiceResult<List<ProductReviewsResponse>>>
}