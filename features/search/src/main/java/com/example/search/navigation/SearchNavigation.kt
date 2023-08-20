package com.example.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navigation.OtherScreens
import com.example.search.SearchScreen

fun NavGraphBuilder.searchScreen(navController: NavHostController) {
    composable(
        route = OtherScreens.Search.route
    ) {
        SearchScreen()
    }
}