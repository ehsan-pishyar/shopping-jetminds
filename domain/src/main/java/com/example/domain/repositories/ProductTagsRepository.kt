package com.example.domain.repositories

import com.example.domain.models.ProductTagsResponse
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface ProductTagsRepository {

    fun getProductTags(): Flow<ServiceResult<List<ProductTagsResponse>>>
    suspend fun getProductTagDetails(tagId: Int): ServiceResult<ProductTagsResponse>
}