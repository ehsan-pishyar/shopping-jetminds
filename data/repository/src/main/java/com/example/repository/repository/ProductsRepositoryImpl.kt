package com.example.repository.repository

import com.example.cache.dao.ProductsDao
import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.ProductsRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import com.example.network.models.ProductsResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val productsDao: ProductsDao
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

    override fun getOnSaleProductsForHome(): Flow<ServiceResult<List<ProductsResponse>>> {
        TODO("Not yet implemented")
    }

    override fun getPopularProductsForHome(): Flow<ServiceResult<List<ProductsResponse>>> {
        TODO("Not yet implemented")
    }

    override fun getTopSalesProductsForHome(): Flow<ServiceResult<List<ProductsResponse>>> {
        TODO("Not yet implemented")
    }

    override fun getNewestProductsForHome(): Flow<ServiceResult<List<ProductsResponse>>> {
        TODO("Not yet implemented")
    }

    override fun getTopRatedProductsForHome(): Flow<ServiceResult<List<ProductsResponse>>> {
        TODO("Not yet implemented")
    }
}