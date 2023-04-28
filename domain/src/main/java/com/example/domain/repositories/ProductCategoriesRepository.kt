package com.example.domain.repositories

import com.example.domain.models.ProductCategoriesResponse
import kotlinx.coroutines.flow.Flow

interface ProductCategoriesRepository {
    fun getProductCategories(): Flow<List<ProductCategoriesResponse>>
    fun getProductCategoryDetails(categoryId: Int): Flow<ProductCategoriesResponse>

    suspend fun refreshCategories()
}