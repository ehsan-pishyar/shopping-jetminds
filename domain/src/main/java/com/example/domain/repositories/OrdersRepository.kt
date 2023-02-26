package com.example.domain.repositories

import com.example.domain.models.OrdersResponse
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface OrdersRepository {

    fun getOrders(): Flow<ServiceResult<List<OrdersResponse>>>
    suspend fun getOrderDetails(orderId: Int): ServiceResult<OrdersResponse>
}