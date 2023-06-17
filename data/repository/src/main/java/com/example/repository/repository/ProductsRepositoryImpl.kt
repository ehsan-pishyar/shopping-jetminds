package com.example.repository.repository

import com.example.cache.dao.ProductsDao
import com.example.cache.models.ProductsResponseEntity
import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.ProductsRepository
import com.example.network.ApiService
import com.example.network.models.ProductsResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ProductsDao
): ProductsRepository {

    override fun getProducts(): Flow<List<ProductsResponse>> {
        return dao.fetchProducts().map { productsEntity ->
            productsEntity.map(ProductsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProducts()
            }
        }
    }

    override fun getProductsByCategoryId(categoryId: Int): Flow<List<ProductsResponse>> {
        return dao.fetchProductsByCategoryId(categoryId).map { productsEntity ->
            productsEntity.map(ProductsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProducts()
            }
        }
    }

    override fun getProductsByTagId(tagId: Int): Flow<List<ProductsResponse>> {
        return dao.fetchProductsByTagId(tagId).map { productsEntity ->
            productsEntity.map(ProductsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProducts()
            }
        }
    }

    override fun getProductsByAttrId(attrId: Int): Flow<List<ProductsResponse>> {
        return dao.fetchProductsByAttrId(attrId).map { productsEntity ->
            productsEntity.map(ProductsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProducts()
            }
        }
    }

    override suspend fun getProductDetails(productId: Int): Flow<ProductsResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshProducts() {
        api.getProducts().also { productsResponseDto ->
            dao.deleteAndInsertProducts(
                products = productsResponseDto.map(
                    ProductsResponseDto::toEntity
                )
            )
        }
    }
}