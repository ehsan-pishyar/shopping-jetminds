package com.example.repository.repository

import com.example.cache.dao.ProductReviewsDao
import com.example.domain.models.ProductReviewsResponse
import com.example.domain.repositories.ProductReviewsRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductReviewsRepositoryImpl @Inject constructor(
    apiService: ApiService,
    productReviewsDao: ProductReviewsDao
): ProductReviewsRepository {

    override fun getProductReviews(): Flow<ServiceResult<List<ProductReviewsResponse>>> {
        TODO("Not yet implemented")
    }
}