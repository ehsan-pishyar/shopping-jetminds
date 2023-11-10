package com.example.shop.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.core.utils.SharedViewModel
import com.example.navigation.BottomNavigationScreens
import com.example.navigation.DetailScreens
import com.example.navigation.OtherScreens
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
            toCartScreen = { navController.navigate(route = PaymentScreens.Cart.route) },
            toProductDetailsScreen = { navController.navigate(route = DetailScreens.ProductDetails.route) },
            toSearchScreen = { navController.navigate(route = OtherScreens.Search.route) },
            toNotificationScreen = { navController.navigate(route = OtherScreens.Notifications.route) }
        )
    }
}