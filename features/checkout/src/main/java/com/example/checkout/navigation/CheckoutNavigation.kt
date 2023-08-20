package com.example.checkout.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.checkout.CheckoutScreen
import com.example.navigation.PaymentScreens

fun NavGraphBuilder.checkoutScreen(navController: NavHostController) {
    composable(
        route = PaymentScreens.Checkout.route
    ) {
        CheckoutScreen()
    }
}