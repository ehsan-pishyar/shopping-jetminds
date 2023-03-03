package com.example.repository.repository

import com.example.cache.dao.ProductAttributesDao
import com.example.domain.models.ProductAttributesResponse
import com.example.domain.repositories.ProductAttributesRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import com.example.network.models.ProductAttributesResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ProductAttributesRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val productAttributesDao: ProductAttributesDao
): ProductAttributesRepository {

    override fun getProductAttributes(): Flow<ServiceResult<List<ProductAttributesResponse>>> = flow {
        emit(ServiceResult.Loading())

        if (productAttributesDao.isProductAttributesCacheAvailable() > 0) {
            emit(ServiceResult.Success(data = productAttributesDao.fetchProductAttrs().map { it.toDomain() }))
        }

        val response = try {
            apiService.getProductAttributes()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } as ProductAttributesResponseDto

        response.let { attrs ->
            productAttributesDao.insertProductAttributes(listOf(attrs.toEntity()))
            emit(ServiceResult.Success(productAttributesDao.fetchProductAttrs().map { it.toDomain() }))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override suspend fun getProductAttributeDetails(attrId: Int): ServiceResult<ProductAttributesResponse> {
        val attrsEntity = productAttributesDao.fetchProductAttrDetails(attrId)

        if (productAttributesDao.isProductAttributesCacheAvailable() > 0) {
            return ServiceResult.Success(data = attrsEntity.toDomain())
        }

        val response = try {
            apiService.getProductAttributeDetails(attrId)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, error = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, error = e.message)
        }

        response.let {
            productAttributesDao.insertProductAttrDetails(it.toEntity())
            return ServiceResult.Success(productAttributesDao.fetchProductAttrDetails(attrId).toDomain())
        }
    }
}