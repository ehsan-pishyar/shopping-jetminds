package com.example.orders.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navigation.PaymentScreens
import com.example.orders.OrdersScreen

fun NavGraphBuilder.ordersScreen(navController: NavHostController) {
    composable(
        route = PaymentScreens.Orders.route
    ) {
        OrdersScreen()
    }
}