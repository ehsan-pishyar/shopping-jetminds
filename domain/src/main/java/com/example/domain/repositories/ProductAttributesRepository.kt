package com.example.domain.repositories

import com.example.domain.models.ProductAttributesResponse
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface ProductAttributesRepository {

    fun getProductAttributes(): Flow<ServiceResult<List<ProductAttributesResponse>>>
    suspend fun getProductAttributeDetails(attrId: Int): ServiceResult<ProductAttributesResponse>
}