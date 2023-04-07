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

    override fun getProducts(): Flow<ServiceResult<List<ProductsResponse>>> = flow {
        emit(ServiceResult.Loading())

        if (productsDao.isProductsCacheAvailable() > 0) {
            emit(ServiceResult.Success(data = productsDao.fetchProducts().map { it.toDomain() }))
        }

        val response = try {
            apiService.getProducts()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } as ProductsResponseDto

        response.let { products ->
            productsDao.insertProducts(listOf(products.toEntity()))
            emit(ServiceResult.Success(productsDao.fetchProducts().map { it.toDomain() }))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getProductsByCategoryId(categoryId: Int): Flow<ServiceResult<List<ProductsResponse>>> = flow {
        emit(ServiceResult.Loading())

        if (productsDao.isProductsCacheAvailable() > 0) {
            emit(ServiceResult.Success(data = productsDao.fetchProductsByCategoryId(categoryId).map { it.toDomain() }))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getProductsByTagId(tagId: Int): Flow<ServiceResult<List<ProductsResponse>>> = flow {
        emit(ServiceResult.Loading())

        if (productsDao.isProductsCacheAvailable() > 0) {
            emit(ServiceResult.Success(data = productsDao.fetchProductsByTagId(tagId).map { it.toDomain() }))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getProductsByAttrId(attrId: Int): Flow<ServiceResult<List<ProductsResponse>>> = flow {
        emit(ServiceResult.Loading())

        if (productsDao.isProductsCacheAvailable() > 0) {
            emit(ServiceResult.Success(data = productsDao.fetchProductsByAttrId(attrId).map { it.toDomain() }))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override suspend fun getProductDetails(productId: Int): ServiceResult<ProductsResponse> {
        val productsEntity = productsDao.fetchProductDetails(productId)

        if (productsDao.isProductsCacheAvailable() > 0) {
            return ServiceResult.Success(data = productsEntity.toDomain())
        }

        val response = try {
            apiService.getProductDetails(productId)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, error = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, error = e.message)
        }

        response.let {
            productsDao.insertProductsDetails(it.toEntity())
            return ServiceResult.Success(productsDao.fetchProductDetails(productId).toDomain())
        }
    }

    override fun getOnSaleProductsForHome(): Flow<ServiceResult<List<ProductsResponse>>> = flow {
        emit(ServiceResult.Loading())

        if (productsDao.isProductsCacheAvailable() > 0) {
            emit(ServiceResult.Success(data = productsDao.fetchOnSaleProducts().map { it.toDomain() }))
        }

        val responseDto = try {
            apiService.getProducts()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } as ProductsResponseDto

        responseDto.let { products ->
            productsDao.insertProducts(listOf(products.toEntity()))
            emit(ServiceResult.Success(data = productsDao.fetchOnSaleProducts().map { it.toDomain() }))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getPopularProductsForHome(): Flow<ServiceResult<List<ProductsResponse>>> = flow {
        emit(ServiceResult.Loading())

        if (productsDao.isProductsCacheAvailable() > 0) {
            emit(ServiceResult.Success(data = productsDao.fetchPopularProducts().map { it.toDomain() }))
        }

        val responseDto = try {
            apiService.getProducts()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } as ProductsResponseDto

        responseDto.let { products ->
            productsDao.insertProducts(listOf(products.toEntity()))
            emit(ServiceResult.Success(data = productsDao.fetchPopularProducts().map { it.toDomain() }))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getTopSalesProductsForHome(): Flow<ServiceResult<List<ProductsResponse>>> = flow {
        emit(ServiceResult.Loading())

        if (productsDao.isProductsCacheAvailable() > 0) {
            emit(ServiceResult.Success(data = productsDao.fetchTopSalesProducts().map { it.toDomain() }))
        }

        val responseDto = try {
            apiService.getProducts()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } as ProductsResponseDto

        responseDto.let { products ->
            productsDao.insertProducts(listOf(products.toEntity()))
            emit(ServiceResult.Success(data = productsDao.fetchTopSalesProducts().map { it.toDomain() }))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getNewestProductsForHome(): Flow<ServiceResult<List<ProductsResponse>>> = flow {
        emit(ServiceResult.Loading())

        if (productsDao.isProductsCacheAvailable() > 0) {
            emit(ServiceResult.Success(data = productsDao.fetchNewestProducts().map { it.toDomain() }))
        }

        val responseDto = try {
            apiService.getProducts()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } as ProductsResponseDto

        responseDto.let { products ->
            productsDao.insertProducts(listOf(products.toEntity()))
            emit(ServiceResult.Success(data = productsDao.fetchNewestProducts().map { it.toDomain() }))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override fun getTopRatedProductsForHome(): Flow<ServiceResult<List<ProductsResponse>>> = flow {
        emit(ServiceResult.Loading())

        if (productsDao.isProductsCacheAvailable() > 0) {
            emit(ServiceResult.Success(data = productsDao.fetchTopRatedProducts().map { it.toDomain() }))
        }

        val responseDto = try {
            apiService.getProducts()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } as ProductsResponseDto

        responseDto.let { products ->
            productsDao.insertProducts(listOf(products.toEntity()))
            emit(ServiceResult.Success(data = productsDao.fetchTopRatedProducts().map { it.toDomain() }))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }
}