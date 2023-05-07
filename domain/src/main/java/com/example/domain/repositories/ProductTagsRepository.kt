package com.example.domain.repositories

import com.example.domain.models.ProductTagsResponse
import kotlinx.coroutines.flow.Flow

interface ProductTagsRepository {

    fun getProductTags(): Flow<List<ProductTagsResponse>>
    fun getProductTagDetails(tagId: Int): Flow<ProductTagsResponse>
    suspend fun refreshProductTags()
}