package com.example.repository.repository

import com.example.cache.dao.ProductTagsDao
import com.example.cache.models.ProductTagsResponseEntity
import com.example.domain.models.ProductTagsResponse
import com.example.domain.repositories.ProductTagsRepository
import com.example.network.ApiService
import com.example.network.models.ProductTagsResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductTagsRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ProductTagsDao
): ProductTagsRepository {

    override fun getProductTags(): Flow<List<ProductTagsResponse>> {
        return dao.fetchProductTags().map { tagsEntity ->
            tagsEntity.map(ProductTagsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProductTags()
            }
        }
    }

    override fun getProductTagDetails(tagId: Int): Flow<ProductTagsResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshProductTags() {
        api.getProductTags().also { tagsDto ->
            dao.deleteAndInsertProductTags(
                tags = tagsDto.map(
                    ProductTagsResponseDto::toEntity
                )
            )
        }
    }
}