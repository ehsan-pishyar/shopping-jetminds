package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.orders.GetOrderDetailsUseCase
import com.example.domain.use_cases.orders.GetOrdersUseCase
import com.example.domain.utils.ServiceResult
import com.example.shoppingjetminds.uistates.MainOrderDetailsUiState
import com.example.shoppingjetminds.uistates.MainOrdersUiState
import com.example.shoppingjetminds.uistates.OrderDetailsUiState
import com.example.shoppingjetminds.uistates.OrdersUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrdersViewModel @Inject constructor(
    private val getOrdersUseCase: GetOrdersUseCase,
    private val getOrderDetailsUseCase: GetOrderDetailsUseCase
): ViewModel() {

    private var _ordersState = MutableStateFlow(MainOrdersUiState(OrdersUiState.Loading))
    val orderState = _ordersState.asStateFlow()

    private var _orderDetailsState = MutableStateFlow(MainOrderDetailsUiState(OrderDetailsUiState.Loading))
    val orderDetailsState = _orderDetailsState.asStateFlow()

    init {
        getOrders()
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
}