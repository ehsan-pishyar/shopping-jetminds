package com.example.domain.repositories

import com.example.domain.models.OrdersResponse
import kotlinx.coroutines.flow.Flow

interface OrdersRepository {

    fun getOrders(): Flow<List<OrdersResponse>>
    fun getOrderDetails(orderId: Int): Flow<OrdersResponse>
    suspend fun refreshOrders()
}