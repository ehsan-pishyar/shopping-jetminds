package com.example.domain.use_cases.orders

import com.example.domain.models.OrdersResponse
import com.example.domain.repositories.OrdersRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetOrderDetailsUseCase constructor(
    private val ordersRepository: OrdersRepository
) {

    operator fun invoke(orderId: Int): Flow<ServiceResult<OrdersResponse>> =
        ordersRepository.getOrderDetails(orderId).asResult()
}