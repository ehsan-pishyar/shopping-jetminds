package com.example.domain.use_cases.product_reviews

import com.example.domain.models.ProductReviewsResponse
import com.example.domain.repositories.ProductReviewsRepository
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow


class GetProductReviewsUseCase constructor(
    private val productReviewsRepository: ProductReviewsRepository
) {

    operator fun invoke(): Flow<ServiceResult<List<ProductReviewsResponse>>> =
        productReviewsRepository.getProductReviews()
}