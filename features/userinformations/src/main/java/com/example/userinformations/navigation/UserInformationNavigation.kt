package com.example.userinformations.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navigation.DetailScreens
import com.example.userinformations.UserInformationScreen

fun NavGraphBuilder.userInformationScreen(navController: NavHostController) {
    composable(
        route = DetailScreens.UserInformation.route
    ) {
        UserInformationScreen()
    }
}