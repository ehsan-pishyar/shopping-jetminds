package com.example.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.core.utils.SharedViewModel
import com.example.home.HomeScreen
import com.example.navigation.AuthScreens
import com.example.navigation.BottomNavigationScreens
import com.example.navigation.DetailScreens
import com.example.navigation.OtherScreens
import com.example.navigation.PaymentScreens

fun NavGraphBuilder.homeScreen(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = BottomNavigationScreens.Home.route
    ) {
        HomeScreen(
            sharedViewModel = sharedViewModel,
            toCartScreen = { navController.navigate(PaymentScreens.Cart.route) },
            toNotificationScreen = { navController.navigate(OtherScreens.Notifications.route) },
            toProfileScreen = { navController.navigate(AuthScreens.Account.route) },
            toShopScreen = { navController.navigate(BottomNavigationScreens.Shop.route) },
            toProductDetailsScreen = { navController.navigate(DetailScreens.ProductDetails.route) }
        )
    }
}