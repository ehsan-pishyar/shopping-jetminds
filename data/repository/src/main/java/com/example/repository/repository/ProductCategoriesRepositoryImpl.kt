package com.example.repository.repository

import com.example.cache.dao.ProductCategoriesDao
import com.example.domain.models.ProductCategoriesResponse
import com.example.domain.repositories.ProductCategoriesRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import com.example.network.models.ProductCategoriesResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ProductCategoriesRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val productCategoriesDao: ProductCategoriesDao
): ProductCategoriesRepository {

    override fun getProductCategories(): Flow<ServiceResult<List<ProductCategoriesResponse>>> = flow {
        emit(ServiceResult.Loading())

        if (productCategoriesDao.isProductCategoryCacheAvailable() > 0) {
            emit(ServiceResult.Success(data = productCategoriesDao.fetchProductCategories().map { it.toDomain() }))
        }

        val response = try {
            apiService.getProductsCategories()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } as ProductCategoriesResponseDto

        response.let { categories ->
            productCategoriesDao.insertProductCategoriesToDb(listOf(categories.toEntity()))
            emit(ServiceResult.Success(productCategoriesDao.fetchProductCategories().map { it.toDomain() }))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override suspend fun getProductCategoryDetails(categoryId: Int): ServiceResult<ProductCategoriesResponse> {
        val categoryEntity = productCategoriesDao.fetchProductCategoryDetails(categoryId)

        if (productCategoriesDao.isProductCategoryCacheAvailable() > 0) {
            return ServiceResult.Success(data = categoryEntity.toDomain())
        }

        val response = try {
            apiService.getProductCategoryDetails(categoryId)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, error = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, error = e.message)
        }

        response.let {
            productCategoriesDao.insertProductCategoryDetails(it.toEntity())
            return ServiceResult.Success(productCategoriesDao.fetchProductCategoryDetails(categoryId).toDomain())
        }
    }
}