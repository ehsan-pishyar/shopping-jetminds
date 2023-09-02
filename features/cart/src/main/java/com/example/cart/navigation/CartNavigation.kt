package com.example.cart.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.cart.CartScreen
import com.example.core.utils.SharedViewModel
import com.example.navigation.PaymentScreens

fun NavGraphBuilder.cartScreen(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = PaymentScreens.Cart.route
    ) {
        CartScreen(
            sharedViewModel = sharedViewModel
        )
    }
}