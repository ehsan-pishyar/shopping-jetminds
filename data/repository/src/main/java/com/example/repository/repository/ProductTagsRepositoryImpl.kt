package com.example.repository.repository

import com.example.cache.dao.ProductTagsDao
import com.example.domain.models.ProductTagsResponse
import com.example.domain.repositories.ProductTagsRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import com.example.network.models.ProductTagsResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ProductTagsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val productTagsDao: ProductTagsDao
): ProductTagsRepository {

    override fun getProductTags(): Flow<ServiceResult<List<ProductTagsResponse>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getProductTagDetails(tagId: Int): ServiceResult<ProductTagsResponse> {
        TODO("Not yet implemented")
    }
}