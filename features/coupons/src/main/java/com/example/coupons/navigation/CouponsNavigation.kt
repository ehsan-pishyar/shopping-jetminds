package com.example.coupons.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.coupons.CouponsScreen
import com.example.navigation.PaymentScreens

fun NavGraphBuilder.couponsScreen(navController: NavHostController) {
    composable(
        route = PaymentScreens.Coupons.route
    ) {
        CouponsScreen()
    }
}