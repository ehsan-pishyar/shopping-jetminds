package com.example.repository.repository

import com.example.cache.dao.ProductShippingClassesDao
import com.example.domain.models.ProductShippingClassesResponse
import com.example.domain.repositories.ProductShippingClassesRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductShippingClassesRepositoryImpl @Inject constructor(
    apiService: ApiService,
    productShippingClassesDao: ProductShippingClassesDao
): ProductShippingClassesRepository {

    override fun getProductShippingClasses(): Flow<ServiceResult<List<ProductShippingClassesResponse>>> {
        TODO("Not yet implemented")
    }
}