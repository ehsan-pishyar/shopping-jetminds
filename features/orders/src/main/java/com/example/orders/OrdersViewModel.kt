/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/11/23, 12:41 AM
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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.cart.GetCartTotalCountsUseCase
import com.example.domain.use_cases.orders.GetOrderDetailsUseCase
import com.example.domain.use_cases.orders.GetOrdersUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrdersViewModel @Inject constructor(
    private val getOrdersUseCase: GetOrdersUseCase,
    private val getOrderDetailsUseCase: GetOrderDetailsUseCase,
    private val getCartTotalCountsUseCase: GetCartTotalCountsUseCase
): ViewModel() {

    private var _ordersState = MutableStateFlow(MainOrdersUiState(OrdersUiState.Loading))
    val orderState = _ordersState.asStateFlow()

    private var _orderDetailsState = MutableStateFlow(MainOrderDetailsUiState(OrderDetailsUiState.Loading))
    val orderDetailsState = _orderDetailsState.asStateFlow()

    private val _cartTotalCountState = MutableStateFlow(0)
    val cartTotalCountState = _cartTotalCountState.asStateFlow()

    init {
        getOrders()
        getCartTotalCount()
    }

    private fun getOrders() {
        viewModelScope.launch {
            getOrdersUseCase.invoke().collect { ordersResult ->
                val ordersUiStateResult = when (ordersResult) {
                    ServiceResult.Loading -> OrdersUiState.Loading
                    is ServiceResult.Success -> OrdersUiState.Success(orders =  ordersResult.data)
                    is ServiceResult.Error -> OrdersUiState.Error(message = ordersResult.throwable?.message!!)
                }
                _ordersState.value = MainOrdersUiState(ordersUiState = ordersUiStateResult)
            }
        }
    }

    fun getOrderDetails(orderId: Int) {
        viewModelScope.launch {
            getOrderDetailsUseCase.invoke(orderId = orderId).collect { orderDetailsResult ->
                val orderDetailsUiStateResult = when (orderDetailsResult) {
                    ServiceResult.Loading -> OrderDetailsUiState.Loading
                    is ServiceResult.Success -> OrderDetailsUiState.Success(orderDetails = orderDetailsResult.data)
                    is ServiceResult.Error -> OrderDetailsUiState.Error(message = orderDetailsResult.throwable?.message!!)
                }
                _orderDetailsState.value = MainOrderDetailsUiState(orderDetailsUiState = orderDetailsUiStateResult)
            }
        }
    }

    private fun getCartTotalCount() {
        viewModelScope.launch {
            getCartTotalCountsUseCase.invoke().collect {
                _cartTotalCountState.value = it!!
            }
        }
    }
}