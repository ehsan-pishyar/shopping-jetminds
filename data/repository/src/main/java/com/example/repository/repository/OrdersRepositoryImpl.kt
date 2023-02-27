package com.example.repository.repository

import com.example.cache.dao.OrdersDao
import com.example.domain.models.OrdersResponse
import com.example.domain.repositories.OrdersRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class OrdersRepositoryImpl @Inject constructor(
    apiService: ApiService,
    ordersDao: OrdersDao
): OrdersRepository {

    override fun getOrders(): Flow<ServiceResult<List<OrdersResponse>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getOrderDetails(orderId: Int): ServiceResult<OrdersResponse> {
        TODO("Not yet implemented")
    }
}