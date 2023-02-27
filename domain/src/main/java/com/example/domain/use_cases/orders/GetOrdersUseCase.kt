package com.example.domain.use_cases.orders

import com.example.domain.models.OrdersResponse
import com.example.domain.repositories.OrdersRepository
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

class GetOrdersUseCase constructor(
    private val ordersRepository: OrdersRepository
){

    operator fun invoke(): Flow<ServiceResult<List<OrdersResponse>>> =
        ordersRepository.getOrders()
}