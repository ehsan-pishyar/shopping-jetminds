package com.example.repository.repository

import com.example.cache.dao.ProductAttributesDao
import com.example.cache.models.ProductAttributesResponseEntity
import com.example.domain.models.ProductAttributesResponse
import com.example.domain.repositories.ProductAttributesRepository
import com.example.network.ApiService
import com.example.network.models.ProductAttributesResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductAttributesRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ProductAttributesDao
): ProductAttributesRepository {

    override fun getProductAttributes(): Flow<List<ProductAttributesResponse>> {
        return dao.fetchProductAttrs().map { attrsEntity ->
            attrsEntity.map(ProductAttributesResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProductAttributes()
            }
        }
    }

    override fun getProductAttributeDetails(attrId: Int): Flow<ProductAttributesResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshProductAttributes() {
        api.getProductAttributes().also { attrsDto ->
            println("Product Attr Dto: ${attrsDto[0].name}")
            dao.deleteAndInsertProductAttributes(
                attrs = attrsDto.map(
                    ProductAttributesResponseDto::toEntity
                ).also { attrsEntity ->
                    println("Product Attr Entity: ${attrsEntity[0].name}")
                }
            )
        }
    }
}