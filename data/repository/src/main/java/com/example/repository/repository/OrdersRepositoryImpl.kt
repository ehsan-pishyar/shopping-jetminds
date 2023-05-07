package com.example.repository.repository

import com.example.cache.dao.OrdersDao
import com.example.cache.models.OrdersResponseEntity
import com.example.domain.models.OrdersResponse
import com.example.domain.repositories.OrdersRepository
import com.example.network.ApiService
import com.example.network.models.OrdersResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class OrdersRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: OrdersDao
): OrdersRepository {

    override fun getOrders(): Flow<List<OrdersResponse>> {
        return dao.fetchOrders().map { ordersEntity ->
            ordersEntity.map(OrdersResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshOrders()
            }
        }
    }

    override fun getOrderDetails(orderId: Int): Flow<OrdersResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshOrders() {
        api.getOrders().also { ordersResponseDtos ->
            dao.deleteAndInsertOrders(
                orders = ordersResponseDtos.map(
                    OrdersResponseDto::toEntity
                )
            )
        }
    }
}