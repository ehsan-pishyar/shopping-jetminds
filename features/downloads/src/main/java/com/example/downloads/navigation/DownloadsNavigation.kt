package com.example.downloads.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.downloads.DownloadScreen
import com.example.navigation.OtherScreens

fun NavGraphBuilder.downloadsScreen(navController: NavHostController) {
    composable(
        route = OtherScreens.Downloads.route
    ) {
        DownloadScreen()
    }
}