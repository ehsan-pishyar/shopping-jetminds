package com.example.repository.repository

import com.example.cache.dao.ProductVariationsDao
import com.example.cache.models.ProductVariationsResponseEntity
import com.example.domain.models.ProductVariationsResponse
import com.example.domain.repositories.ProductVariationsRepository
import com.example.network.ApiService
import com.example.network.models.ProductVariationsResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductVariationsRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ProductVariationsDao
): ProductVariationsRepository {

    override fun getProductVariations(productId: Int): Flow<List<ProductVariationsResponse>> {
        return dao.fetchProductVariations(productId).map { variationsEntity ->
            variationsEntity.map(ProductVariationsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProductVariations(productId)
            }
        }
    }

    override fun getProductVariationDetails(
        productId: Int,
        variationId: Int
    ): Flow<ProductVariationsResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshProductVariations(productId: Int) {
        api.getProductVariations(productId).also { variationsDto ->
            dao.deleteAndInsertProductVariations(
                variations = variationsDto.map(
                    ProductVariationsResponseDto::toEntity
                )
            )
        }
    }
}