package com.example.shoppingjetminds.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.shoppingjetminds.views.auth.*
import com.example.shoppingjetminds.views.main.*
import com.example.shoppingjetminds.views.start.*

@Composable
fun AppNavigation(navHostController: NavHostController) {
    NavHost(
        route = Graph.ROOT,
        navController = navHostController,
        startDestination = Graph.START
    ) {
        addStartTopLevel(navHostController)
        addAuthTopLevel(navHostController)
        addMainTopLevel(navHostController)
    }
}

fun NavGraphBuilder.addStartTopLevel(navController: NavController) {
    navigation(
        route = Graph.START,
        startDestination = StartScreens.Splash.route
    ) {
        composable(route = StartScreens.Splash.route) {
            SplashScreen(
                toOnBoardingScreen = { navController.navigate(route = StartScreens.OnBoarding.route) },
                toHomeScreen = { navController.navigate(route = MainScreens.Home.route) }
            )
        }
        composable(route = StartScreens.OnBoarding.route) {
            OnBoardingScreen {
                navController.navigate(route = MainScreens.Home.route)
            }
        }
    }
}

fun NavGraphBuilder.addAuthTopLevel(navController: NavController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreens.Login.route
    ) {
        composable(route = AuthScreens.Login.route) {
            LoginScreen(
                toHomeScreen = { navController.navigate(route = MainScreens.Home.route) },
                toVerificationScreen = { navController.navigate(route = AuthScreens.Verification.route) }
            )
        }
    }
}

fun NavGraphBuilder.addMainTopLevel(navController: NavController) {
    navigation(
        route = Graph.MAIN,
        startDestination = MainScreens.Home.route
    ) {
        composable(route = MainScreens.Home.route) {
            HomeScreen()
        }
        composable(route = MainScreens.Shop.route) {
            ShopScreen()
        }
        composable(route = MainScreens.Category.route) {
            CategoryScreen()
        }
        composable(route = MainScreens.Favorites.route) {
            FavoritesScreen()
        }
        composable(route = MainScreens.Account.route) {
            AccountScreen {
                navController.navigate(route = AuthScreens.Login.route)
            }
        }
    }
}

object Graph {
    const val ROOT = "root"
    const val START = "start"
    const val AUTH = "auth"
    const val MAIN = "main"
}