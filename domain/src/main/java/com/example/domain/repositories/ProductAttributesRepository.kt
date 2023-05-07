package com.example.domain.repositories

import com.example.domain.models.ProductAttributesResponse
import kotlinx.coroutines.flow.Flow

interface ProductAttributesRepository {

    fun getProductAttributes(): Flow<List<ProductAttributesResponse>>
    fun getProductAttributeDetails(attrId: Int): Flow<ProductAttributesResponse>
    suspend fun refreshProductAttributes()
}