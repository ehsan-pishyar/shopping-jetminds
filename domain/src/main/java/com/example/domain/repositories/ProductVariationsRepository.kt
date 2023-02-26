package com.example.domain.repositories

import com.example.domain.models.ProductVariationsResponse
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface ProductVariationsRepository {

    fun getProductVariations(productId: Int): Flow<ServiceResult<List<ProductVariationsResponse>>>
    suspend fun getProductVariationDetails(productId: Int, variationId: Int): ServiceResult<ProductVariationsResponse>
}