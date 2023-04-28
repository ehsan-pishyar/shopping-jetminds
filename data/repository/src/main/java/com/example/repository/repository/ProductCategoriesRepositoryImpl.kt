package com.example.repository.repository

import com.example.cache.dao.ProductCategoriesDao
import com.example.cache.models.ProductCategoriesResponseEntity
import com.example.domain.models.ProductCategoriesResponse
import com.example.domain.repositories.ProductCategoriesRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import com.example.network.models.ProductCategoriesResponseDto
import com.example.repository.data_source.local.LocalProductCategoriesDataSource
import com.example.repository.data_source.remote.RemoteProductCategoriesDataSource
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import java.io.IOException
import javax.inject.Inject

class ProductCategoriesRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ProductCategoriesDao
): ProductCategoriesRepository {

    override fun getProductCategories(): Flow<List<ProductCategoriesResponse>> {
        println("repository started")
        return dao.fetchProductCategories().map { categoriesEntity ->
            categoriesEntity.map(ProductCategoriesResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshCategories()
            }
        }
    }

    override fun getProductCategoryDetails(categoryId: Int): Flow<ProductCategoriesResponse> {
        TODO("Not yet implemented")
    }


    override suspend fun refreshCategories() {
        api.getProductCategories()
            .also { categoriesDto ->
                dao.deleteAndInsertCategories(categories = categoriesDto.map {it.toEntity()})
            }
    }
}