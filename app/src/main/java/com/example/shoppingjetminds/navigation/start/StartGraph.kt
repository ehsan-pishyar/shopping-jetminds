package com.example.shoppingjetminds.navigation.start

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.example.navigation.Graph
import com.example.navigation.StartScreens
import com.example.onboarding.navigation.onBoardingScreen
import com.example.splash.navigation.splashScreen

fun NavGraphBuilder.addStartTopLevel(navController: NavHostController) {
    navigation(
        route = Graph.START,
        startDestination = StartScreens.Splash.route
    ) {
        splashScreen(navController = navController)
        onBoardingScreen(navController = navController)
    }
}