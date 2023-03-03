package com.example.repository.repository

import com.example.cache.dao.OrdersDao
import com.example.domain.models.OrdersResponse
import com.example.domain.repositories.OrdersRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import com.example.network.models.OrdersResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class OrdersRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val ordersDao: OrdersDao
): OrdersRepository {

    override fun getOrders(): Flow<ServiceResult<List<OrdersResponse>>> = flow {
        emit(ServiceResult.Loading())

        if (ordersDao.isOrdersCacheAvailable() > 0) {
            emit(ServiceResult.Success(data = ordersDao.fetchOrders().map { it.toDomain() }))
        }

        val response = try {
            apiService.getOrders()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } as OrdersResponseDto

        response.let { orders ->
            ordersDao.insertOrders(listOf(orders.toEntity()))
            emit(ServiceResult.Success(ordersDao.fetchOrders().map { it.toDomain() }))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override suspend fun getOrderDetails(orderId: Int): ServiceResult<OrdersResponse> {
        val ordersEntity = ordersDao.fetchOrderDetails(orderId)

        if (ordersDao.isOrdersCacheAvailable() > 0) {
            return ServiceResult.Success(data = ordersEntity.toDomain())
        }

        val response = try {
            apiService.getOrderDetails(orderId)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, error = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, error = e.message)
        }

        response.let {
            ordersDao.insertOrderDetails(it.toEntity())
            return ServiceResult.Success(ordersDao.fetchOrderDetails(orderId).toDomain())
        }
    }
}