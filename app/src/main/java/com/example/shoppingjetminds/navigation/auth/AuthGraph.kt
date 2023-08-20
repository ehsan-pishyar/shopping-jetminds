package com.example.shoppingjetminds.navigation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.example.login.navigation.loginScreen
import com.example.navigation.AuthScreens
import com.example.navigation.Graph
import com.example.verification.navigation.verificationScreen

fun NavGraphBuilder.addAuthTopLevel(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreens.Login.route
    ) {
        loginScreen(navController)
        verificationScreen(navController)
    }
}