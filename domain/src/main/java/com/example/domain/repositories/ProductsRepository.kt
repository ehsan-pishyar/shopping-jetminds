package com.example.domain.repositories

import com.example.domain.models.ProductsResponse
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun getProducts(): Flow<List<ProductsResponse>>
    fun getProductsByCategoryId(categoryId: Int): Flow<List<ProductsResponse>>
    fun getProductsByTagId(tagId: Int): Flow<List<ProductsResponse>>
    fun getProductsByAttrId(attrId: Int): Flow<List<ProductsResponse>>
    suspend fun getProductDetails(productId: Int): Flow<ProductsResponse>

    fun getOnSaleProductsForHome(): Flow<List<ProductsResponse>>
    fun getPopularProductsForHome(): Flow<List<ProductsResponse>>
    fun getTopSalesProductsForHome(): Flow<List<ProductsResponse>>
    fun getNewestProductsForHome(): Flow<List<ProductsResponse>>
    fun getTopRatedProductsForHome(): Flow<List<ProductsResponse>>

    suspend fun refreshProducts()
}