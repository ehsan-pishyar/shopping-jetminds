package com.example.repository.repository

import com.example.cache.dao.ProductVariationsDao
import com.example.domain.models.ProductVariationsResponse
import com.example.domain.repositories.ProductVariationsRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import com.example.network.models.ProductCategoriesResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ProductVariationsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val productVariationsDao: ProductVariationsDao
): ProductVariationsRepository {

    override fun getProductVariations(productId: Int): Flow<ServiceResult<List<ProductVariationsResponse>>> = flow {
        TODO("Not yet implemented")
    }

    override suspend fun getProductVariationDetails(
        productId: Int,
        variationId: Int
    ): ServiceResult<ProductVariationsResponse> {
        TODO("Not yet implemented")
    }
}