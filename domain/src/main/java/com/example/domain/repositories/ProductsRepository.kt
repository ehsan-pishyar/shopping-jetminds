package com.example.domain.repositories

import com.example.domain.models.ProductsResponse
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun getProducts(): Flow<List<ProductsResponse>>
    fun getProductsByCategoryId(categoryId: Int): Flow<List<ProductsResponse>>
    fun getProductsByTagId(tagId: Int): Flow<List<ProductsResponse>>
    fun getProductsByAttrId(attrId: Int): Flow<List<ProductsResponse>>
    suspend fun getProductDetails(productId: Int): Flow<ProductsResponse>

    fun getNewestProducts(): Flow<List<ProductsResponse>>
    fun getPopularProducts(): Flow<List<ProductsResponse>>
    fun getTopRatedProducts(): Flow<List<ProductsResponse>>
    fun getOnSalesProducts(): Flow<List<ProductsResponse>>
    fun getTopSalesProducts(): Flow<List<ProductsResponse>>
    fun getLowestPriceProducts(): Flow<List<ProductsResponse>>
    fun getHighestPriceProducts(): Flow<List<ProductsResponse>>

    suspend fun refreshProducts()
}