package com.example.domain.repositories

import com.example.domain.models.ProductsResponse
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {

    fun getProducts(): Flow<ServiceResult<List<ProductsResponse>>>
    fun getProductsByCategoryId(categoryId: Int): Flow<ServiceResult<List<ProductsResponse>>>
    fun getProductsByTagId(tagId: Int): Flow<ServiceResult<List<ProductsResponse>>>
    fun getProductsByAttrId(attrId: Int): Flow<ServiceResult<List<ProductsResponse>>>
    fun getProductDetails(productId: Int): ServiceResult<ProductsResponse>
}