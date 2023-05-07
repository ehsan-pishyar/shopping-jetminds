package com.example.domain.repositories

import com.example.domain.models.ProductVariationsResponse
import kotlinx.coroutines.flow.Flow

interface ProductVariationsRepository {

    fun getProductVariations(productId: Int): Flow<List<ProductVariationsResponse>>
    fun getProductVariationDetails(productId: Int, variationId: Int): Flow<ProductVariationsResponse>
    suspend fun refreshProductVariations(productId: Int)
}