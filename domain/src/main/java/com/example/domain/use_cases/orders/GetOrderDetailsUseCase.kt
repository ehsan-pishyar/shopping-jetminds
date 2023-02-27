package com.example.domain.use_cases.orders

import com.example.domain.models.OrdersResponse
import com.example.domain.repositories.OrdersRepository
import com.example.domain.utils.ServiceResult

class GetOrderDetailsUseCase constructor(
    private val ordersRepository: OrdersRepository
) {

    suspend operator fun invoke(orderId: Int): ServiceResult<OrdersResponse> =
        ordersRepository.getOrderDetails(orderId)
}