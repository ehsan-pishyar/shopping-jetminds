package com.example.shoppingjetminds.viewmodels

import com.example.domain.use_cases.orders.GetOrderDetailsUseCase
import com.example.domain.use_cases.orders.GetOrdersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrdersViewModel @Inject constructor(
    private val getOrdersUseCase: GetOrdersUseCase,
    private val getOrderDetailsUseCase: GetOrderDetailsUseCase
) {
}