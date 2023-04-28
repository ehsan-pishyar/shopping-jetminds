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
    override fun getOrders(): Flow<ServiceResult<List<OrdersResponse>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getOrderDetails(orderId: Int): ServiceResult<OrdersResponse> {
        TODO("Not yet implemented")
    }
}