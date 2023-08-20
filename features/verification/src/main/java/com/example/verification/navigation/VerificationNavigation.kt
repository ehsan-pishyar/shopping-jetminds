package com.example.verification.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navigation.AuthScreens
import com.example.verification.VerificationScreen

fun NavGraphBuilder.verificationScreen(navController: NavHostController) {
    composable(
        route = AuthScreens.Verification.route
    ) {
        VerificationScreen()
    }
}