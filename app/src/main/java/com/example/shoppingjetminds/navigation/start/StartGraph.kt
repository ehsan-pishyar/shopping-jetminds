package com.example.shoppingjetminds.navigation.start

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.shoppingjetminds.navigation.BottomNavigationScreens
import com.example.shoppingjetminds.navigation.Graph
import com.example.shoppingjetminds.navigation.StartScreens
import com.example.shoppingjetminds.views.start.OnBoardingScreen
import com.example.shoppingjetminds.views.start.SplashScreen

fun NavGraphBuilder.addStartTopLevel(navController: NavHostController) {
    navigation(
        route = Graph.START,
        startDestination = StartScreens.Splash.route
    ) {
        composable(route = StartScreens.Splash.route) {
            SplashScreen(
                toOnBoardingScreen = { navController.navigate(route = StartScreens.OnBoarding.route) },
                toHomeScreen = { navController.navigate(route = Graph.MAIN) }
            )
        }
        composable(route = StartScreens.OnBoarding.route) {
            OnBoardingScreen {
                navController.navigate(route = BottomNavigationScreens.Home.route)
            }
        }
    }
}