package com.example.category.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.category.CategoryScreen
import com.example.navigation.BottomNavigationScreens

fun NavGraphBuilder.categoryScreen(navController: NavHostController) {
    composable(
        route = BottomNavigationScreens.Category.route
    ) {
        CategoryScreen()
    }
}