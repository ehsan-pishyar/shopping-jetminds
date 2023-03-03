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

    override fun getProductShippingClasses(): Flow<ServiceResult<List<ProductShippingClassesResponse>>> = flow {
        emit(ServiceResult.Loading())

        if (productShippingClassesDao.isProductShippingClassesCacheAvailable() > 0) {
            emit(ServiceResult.Success(data = productShippingClassesDao.fetchProductShippingClasses().map { it.toDomain() }))
        }

        val response = try {
            apiService.getProductShippingClasses()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } as ProductShippingClassesResponseDto

        response.let { shippingClasses ->
            productShippingClassesDao.insertProductShippingClasses(listOf(shippingClasses.toEntity()))
            emit(ServiceResult.Success(productShippingClassesDao.fetchProductShippingClasses().map { it.toDomain() }))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }
}