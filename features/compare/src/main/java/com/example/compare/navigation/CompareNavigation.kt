package com.example.compare.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.compare.CompareScreen
import com.example.navigation.OtherScreens

fun NavGraphBuilder.compareScreen(navController: NavHostController) {
    composable(
        route = OtherScreens.Compare.route
    ) {
        CompareScreen()
    }
}