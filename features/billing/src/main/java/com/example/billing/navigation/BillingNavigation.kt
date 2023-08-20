package com.example.billing.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.billing.BillingScreen
import com.example.navigation.PaymentScreens

fun NavGraphBuilder.billingScreen(navController: NavHostController) {
    composable(
        route = PaymentScreens.Billing.route
    ) {
        BillingScreen()
    }
}