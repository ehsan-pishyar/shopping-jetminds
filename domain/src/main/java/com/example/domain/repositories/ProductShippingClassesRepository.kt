package com.example.domain.repositories

import com.example.domain.models.ProductShippingClassesResponse
import kotlinx.coroutines.flow.Flow

interface ProductShippingClassesRepository {

    fun getProductShippingClasses(): Flow<List<ProductShippingClassesResponse>>
    suspend fun refreshProductShippingClasses()
}