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

    override suspend fun insertProductDetails(productDetails: ProductsResponse) {
        dao.insertProductsDetails(productDetails = productDetails.toEntity())
    }

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
        return dao.fetchProductDetails(productId = productId).map(ProductsResponseEntity::toDomain)
    }

    override fun getNewestProducts(): Flow<List<ProductsResponse>> {
        return dao.fetchNewestProducts().map { newest ->
            newest.map(ProductsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProducts()
            }
        }
    }

    override fun getPopularProducts(): Flow<List<ProductsResponse>> {
        return dao.fetchPopularProducts().map { popular ->
            popular.map(ProductsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProducts()
            }
        }
    }

    override fun getTopRatedProducts(): Flow<List<ProductsResponse>> {
        return dao.fetchTopRatedProducts().map { topRated ->
            topRated.map(ProductsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProducts()
            }
        }
    }

    override fun getOnSalesProducts(): Flow<List<ProductsResponse>> {
        return dao.fetchOnSaleProducts().map { onSale ->
            onSale.map(ProductsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProducts()
            }
        }
    }

    override fun getTopSalesProducts(): Flow<List<ProductsResponse>> {
        return dao.fetchTopSalesProducts().map { topSales ->
            topSales.map(ProductsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProducts()
            }
        }
    }

    override fun getLowestPriceProducts(): Flow<List<ProductsResponse>> {
        return dao.fetchLowestPriceProducts().map { popular ->
            popular.map(ProductsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProducts()
            }
        }
    }

    override fun getHighestPriceProducts(): Flow<List<ProductsResponse>> {
        return dao.fetchHighestPriceProducts().map { popular ->
            popular.map(ProductsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshProducts()
            }
        }
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