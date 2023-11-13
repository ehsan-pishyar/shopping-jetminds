/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 8/19/23, 10:16 PM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.orders

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