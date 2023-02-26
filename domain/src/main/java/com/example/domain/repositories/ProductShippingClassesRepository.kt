package com.example.domain.repositories

import com.example.domain.models.ProductShippingClassesResponse
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface ProductShippingClassesRepository {

    fun getProductShippingClasses(): Flow<ServiceResult<List<ProductShippingClassesResponse>>>
}