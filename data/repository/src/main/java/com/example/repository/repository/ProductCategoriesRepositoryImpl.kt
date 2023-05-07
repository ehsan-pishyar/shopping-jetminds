package com.example.repository.repository

import com.example.cache.dao.ProductCategoriesDao
import com.example.cache.models.ProductCategoriesResponseEntity
import com.example.domain.models.ProductCategoriesResponse
import com.example.domain.repositories.ProductCategoriesRepository
import com.example.network.ApiService
import com.example.network.models.ProductCategoriesResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class ProductCategoriesRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: ProductCategoriesDao
): ProductCategoriesRepository {

    override fun getProductCategories(): Flow<List<ProductCategoriesResponse>> {
        return dao.fetchProductCategories().map { categoriesEntity ->
            categoriesEntity.map(ProductCategoriesResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshCategories()
            }
        }
    }

    override fun getProductCategoryDetails(categoryId: Int): Flow<ProductCategoriesResponse> {
        return dao.fetchProductCategoryDetails(categoryId).map { productCategoryDetails ->
            productCategoryDetails.toDomain()
        }
    }


    override suspend fun refreshCategories() {
        api.getProductCategories().also { categoriesDto ->
            dao.deleteAndInsertCategories(
                categories = categoriesDto.map(
                    ProductCategoriesResponseDto::toEntity
                )
            )
        }
    }
}