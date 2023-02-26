package com.example.domain.repositories

import com.example.domain.models.ProductCategoriesResponse
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface ProductCategoriesRepository {

    fun getProductCategories(): Flow<ServiceResult<List<ProductCategoriesResponse>>>
    suspend fun getProductCategoryDetails(categoryId: Int): ServiceResult<ProductCategoriesResponse>
}