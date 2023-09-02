package com.example.favorites.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.core.utils.SharedViewModel
import com.example.favorites.FavoritesScreen
import com.example.navigation.DetailScreens
import com.example.navigation.OtherScreens

fun NavGraphBuilder.favoritesScreen(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = OtherScreens.Favorite.route
    ) {
        FavoritesScreen(
            sharedViewModel = sharedViewModel,
            toProductDetailsScreen = { navController.navigate(route = DetailScreens.ProductDetails.route) }
        )
    }
}