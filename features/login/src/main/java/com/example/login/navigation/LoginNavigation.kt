package com.example.login.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.login.LoginScreen
import com.example.navigation.AuthScreens
import com.example.navigation.Graph

fun NavGraphBuilder.loginScreen(navController: NavHostController) {
    composable(
        route = AuthScreens.Login.route
    ) {
        LoginScreen(
            toHomeScreen = { navController.navigate(Graph.MAIN) }
        )
    }
}