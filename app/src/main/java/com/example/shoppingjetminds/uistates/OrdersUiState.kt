package com.example.shoppingjetminds.uistates

import com.example.domain.models.OrdersResponse

sealed interface OrdersUiState {
    object Loading: OrdersUiState
    data class Success(val orders: List<OrdersResponse>): OrdersUiState
    data class Error(val message: String): OrdersUiState
}

sealed interface OrderDetailsUiState {
    object Loading: OrderDetailsUiState
    data class Success(val orderDetails: OrdersResponse): OrderDetailsUiState
    data class Error(val message: String): OrderDetailsUiState
}

data class MainOrdersUiState(
    val ordersUiState: OrdersUiState
)

data class MainOrderDetailsUiState(
    val orderDetailsUiState: OrderDetailsUiState
)