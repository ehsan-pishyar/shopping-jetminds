package com.example.repository.repository

import com.example.cache.dao.ProductReviewsDao
import com.example.cache.models.ProductReviewsResponseEntity
import com.example.domain.models.ProductReviewsResponse
import com.example.domain.repositories.ProductReviewsRepository
import com.example.network.ApiService
import com.example.network.models.ProductReviewsResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductReviewsRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ProductReviewsDao
): ProductReviewsRepository {

    override fun getProductReviews(productId: Int): Flow<List<ProductReviewsResponse>> {
        return dao.fetchProductReviews(productId).map { reviewsEntity ->
            reviewsEntity.map(ProductReviewsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProductReviews()
            }
        }
    }

    override fun getProductReviewDetails(reviewId: Int): Flow<ProductReviewsResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshProductReviews() {
        api.getProductReviews().also { reviewsDto ->
            dao.deleteAndInsertProductReviews(
                reviews = reviewsDto.map(
                    ProductReviewsResponseDto::toEntity
                )
            )
        }
    }
}