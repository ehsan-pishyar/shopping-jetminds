package com.example.productdetails.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.core.utils.SharedViewModel
import com.example.navigation.DetailScreens
import com.example.navigation.PaymentScreens
import com.example.productdetails.ProductDetailsScreen

fun NavGraphBuilder.productDetailsScreen(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {

    composable(
        route = DetailScreens.ProductDetails.route
    ) {
        ProductDetailsScreen(
            sharedViewModel = sharedViewModel,
            toCartScreen = { navController.navigate(PaymentScreens.Cart.route) }
        )
    }
}