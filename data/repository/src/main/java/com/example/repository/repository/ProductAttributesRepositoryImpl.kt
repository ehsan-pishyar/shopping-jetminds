package com.example.repository.repository

import com.example.cache.dao.ProductAttributesDao
import com.example.domain.models.ProductAttributesResponse
import com.example.domain.repositories.ProductAttributesRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductAttributesRepositoryImpl @Inject constructor(
    apiService: ApiService,
    productAttributesDao: ProductAttributesDao
): ProductAttributesRepository {

    override fun getProductAttributes(): Flow<ServiceResult<List<ProductAttributesResponse>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getProductAttributeDetails(attrId: Int): ServiceResult<ProductAttributesResponse> {
        TODO("Not yet implemented")
    }
}