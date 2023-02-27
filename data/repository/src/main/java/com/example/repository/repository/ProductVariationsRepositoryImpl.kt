package com.example.repository.repository

import com.example.cache.dao.ProductVariationsDao
import com.example.domain.models.ProductVariationsResponse
import com.example.domain.repositories.ProductVariationsRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductVariationsRepositoryImpl @Inject constructor(
    apiService: ApiService,
    productVariationsDao: ProductVariationsDao
): ProductVariationsRepository {

    override fun getProductVariations(productId: Int): Flow<ServiceResult<List<ProductVariationsResponse>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getProductVariationDetails(
        productId: Int,
        variationId: Int
    ): ServiceResult<ProductVariationsResponse> {
        TODO("Not yet implemented")
    }
}