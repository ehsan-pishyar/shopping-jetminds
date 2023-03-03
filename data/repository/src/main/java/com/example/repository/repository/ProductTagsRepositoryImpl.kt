package com.example.repository.repository

import com.example.cache.dao.ProductTagsDao
import com.example.domain.models.ProductTagsResponse
import com.example.domain.repositories.ProductTagsRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import com.example.network.models.ProductTagsResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ProductTagsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val productTagsDao: ProductTagsDao
): ProductTagsRepository {

    override fun getProductTags(): Flow<ServiceResult<List<ProductTagsResponse>>> = flow {
        emit(ServiceResult.Loading())

        if (productTagsDao.isProductTagsCacheAvailable() > 0) {
            emit(ServiceResult.Success(data = productTagsDao.fetchProductTags().map { it.toDomain() }))
        }

        val response = try {
            apiService.getProductsTags()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } as ProductTagsResponseDto

        response.let { tags ->
            productTagsDao.insertProductTags(listOf(tags.toEntity()))
            emit(ServiceResult.Success(productTagsDao.fetchProductTags().map { it.toDomain() }))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override suspend fun getProductTagDetails(tagId: Int): ServiceResult<ProductTagsResponse> {
        val tagsEntity = productTagsDao.fetchProductTagDetails(tagId)

        if (productTagsDao.isProductTagsCacheAvailable() > 0) {
            return ServiceResult.Success(data = tagsEntity.toDomain())
        }

        val response = try {
            apiService.getProductTagDetails(tagId)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, error = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, error = e.message)
        }

        response.let {
            productTagsDao.insertProductTagDetails(it.toEntity())
            return ServiceResult.Success(productTagsDao.fetchProductTagDetails(tagId).toDomain())
        }
    }
}