package com.example.repository.repository

import com.example.cache.dao.ProductsDao
import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.ProductsRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    apiService: ApiService,
    productsDao: ProductsDao
): ProductsRepository {

    override fun getProducts(): Flow<ServiceResult<List<ProductsResponse>>> {
        TODO("Not yet implemented")
    }

    override fun getProductsByCategoryId(categoryId: Int): Flow<ServiceResult<List<ProductsResponse>>> {
        TODO("Not yet implemented")
    }

    override fun getProductsByTagId(tagId: Int): Flow<ServiceResult<List<ProductsResponse>>> {
        TODO("Not yet implemented")
    }

    override fun getProductsByAttrId(attrId: Int): Flow<ServiceResult<List<ProductsResponse>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getProductDetails(productId: Int): ServiceResult<ProductsResponse> {
        TODO("Not yet implemented")
    }
}