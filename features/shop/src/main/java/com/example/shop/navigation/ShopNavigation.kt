package com.example.shop.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.core.utils.SharedViewModel
import com.example.navigation.BottomNavigationScreens
import com.example.navigation.DetailScreens
import com.example.navigation.PaymentScreens
import com.example.shop.ShopScreen

fun NavGraphBuilder.shopScreen(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = BottomNavigationScreens.Shop.route
    ) {
        ShopScreen(
            sharedViewModel = sharedViewModel,
            toCartScreen = { navController.navigate(PaymentScreens.Cart.route) },
            toProductDetailsScreen = { navController.navigate(DetailScreens.ProductDetails.route) }
        )
    }
}