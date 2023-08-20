package com.example.favorites.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.favorites.FavoritesScreen
import com.example.navigation.OtherScreens

fun NavGraphBuilder.favoritesScreen(navController: NavHostController) {
    composable(
        route = OtherScreens.Favorite.route
    ) {
        FavoritesScreen()
    }
}