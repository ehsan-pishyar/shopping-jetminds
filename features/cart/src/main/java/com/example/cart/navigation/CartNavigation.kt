package com.example.cart.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.cart.CartScreen
import com.example.navigation.PaymentScreens

fun NavGraphBuilder.cartScreen(navController: NavHostController) {
    composable(
        route = PaymentScreens.Cart.route
    ) {
        CartScreen()
    }
}