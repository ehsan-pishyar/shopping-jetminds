package com.example.repository.repository

import com.example.cache.dao.ProductShippingClassesDao
import com.example.cache.models.ProductShippingClassesResponseEntity
import com.example.domain.models.ProductShippingClassesResponse
import com.example.domain.repositories.ProductShippingClassesRepository
import com.example.network.ApiService
import com.example.network.models.ProductShippingClassesResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductShippingClassesRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ProductShippingClassesDao
): ProductShippingClassesRepository {

    override fun getProductShippingClasses(): Flow<List<ProductShippingClassesResponse>> {
        return dao.fetchProductShippingClasses().map { shippingClassesEntity ->
            shippingClassesEntity.map(ProductShippingClassesResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProductShippingClasses()
            }
        }
    }

    override suspend fun refreshProductShippingClasses() {
        api.getProductShippingClasses().also { productShippingClassesResponseDtos ->
            dao.deleteAndInsertProductShippingClasses(
                productShippingClasses = productShippingClassesResponseDtos.map(
                    ProductShippingClassesResponseDto::toEntity
                )
            )
        }
    }
}