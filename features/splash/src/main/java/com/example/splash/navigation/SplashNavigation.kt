package com.example.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navigation.Graph
import com.example.navigation.StartScreens
import com.example.splash.SplashScreen

fun NavGraphBuilder.splashScreen(
    navController: NavHostController
) {
    composable(
        route = StartScreens.Splash.route
    ) {
        SplashScreen(
            toOnBoardingScreen = { navController.navigate(StartScreens.OnBoarding.route) },
            toHomeScreen = { navController.navigate(Graph.MAIN) }
        )
    }
}