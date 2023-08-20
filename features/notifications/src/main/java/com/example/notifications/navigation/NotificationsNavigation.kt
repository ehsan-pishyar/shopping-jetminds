package com.example.notifications.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navigation.OtherScreens
import com.example.notifications.NotificationsScreen

fun NavGraphBuilder.notificationsScreen(navController: NavHostController) {
    composable(
        route = OtherScreens.Notifications.route
    ) {
        NotificationsScreen()
    }
}