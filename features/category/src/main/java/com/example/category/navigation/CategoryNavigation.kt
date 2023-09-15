package com.example.category.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.category.CategoryScreen
import com.example.core.utils.SharedViewModel
import com.example.navigation.BottomNavigationScreens
import com.example.navigation.PaymentScreens

fun NavGraphBuilder.categoryScreen(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = BottomNavigationScreens.Category.route
    ) {
        CategoryScreen(
            sharedViewModel = sharedViewModel,
            toCartScreen = { navController.navigate(PaymentScreens.Cart.route) },
            toShopScreen = { navController.navigate(BottomNavigationScreens.Shop.route) }
        )
    }
}