package com.example.domain.use_cases.product_reviews

import com.example.domain.models.ProductReviewsResponse
import com.example.domain.repositories.ProductReviewsRepository
import com.example.domain.utils.Result
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow


class GetProductReviewsUseCase constructor(
    private val productReviewsRepository: ProductReviewsRepository
) {

    operator fun invoke(productId: Int): Flow<Result<List<ProductReviewsResponse>>> =
        productReviewsRepository.getProductReviews(productId).asResult()
}