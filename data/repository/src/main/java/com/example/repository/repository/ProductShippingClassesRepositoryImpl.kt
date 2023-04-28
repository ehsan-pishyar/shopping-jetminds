package com.example.repository.repository

import com.example.cache.dao.ProductShippingClassesDao
import com.example.domain.models.ProductShippingClassesResponse
import com.example.domain.repositories.ProductShippingClassesRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import com.example.network.models.ProductShippingClassesResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ProductShippingClassesRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val productShippingClassesDao: ProductShippingClassesDao
): ProductShippingClassesRepository {
    override fun getProductShippingClasses(): Flow<ServiceResult<List<ProductShippingClassesResponse>>> {
        TODO("Not yet implemented")
    }
}