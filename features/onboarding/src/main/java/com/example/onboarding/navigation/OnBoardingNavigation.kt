package com.example.onboarding.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navigation.Graph
import com.example.navigation.StartScreens
import com.example.onboarding.OnBoardingScreen

fun NavGraphBuilder.onBoardingScreen(navController: NavHostController) {
    composable(
        route = StartScreens.OnBoarding.route
    ) {
        OnBoardingScreen {
            navController.navigate(Graph.MAIN)
        }
    }
}