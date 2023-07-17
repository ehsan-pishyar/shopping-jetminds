package com.example.shoppingjetminds.navigation.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.shoppingjetminds.navigation.AuthScreens
import com.example.shoppingjetminds.navigation.BottomNavigationScreens
import com.example.shoppingjetminds.navigation.Graph
import com.example.shoppingjetminds.views.auth.LoginScreen
import com.example.shoppingjetminds.views.auth.VerificationScreen

fun NavGraphBuilder.addAuthTopLevel(navController: NavController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreens.Login.route
    ) {
        composable(route = AuthScreens.Login.route) {
            LoginScreen(
                toHomeScreen = { navController.navigate(route = BottomNavigationScreens.Home.route) },
                toVerificationScreen = { navController.navigate(route = AuthScreens.Verification.route) }
            )
        }
        composable(route = AuthScreens.Verification.route) {
            VerificationScreen()
        }
    }
}