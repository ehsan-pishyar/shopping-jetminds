package com.example.shoppingjetminds.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shoppingjetminds.navigation.auth.addAuthTopLevel
import com.example.shoppingjetminds.navigation.main.MainScreen
import com.example.shoppingjetminds.navigation.start.addStartTopLevel

@Composable
fun AppNavigation(navHostController: NavHostController) {
    NavHost(
        route = Graph.ROOT,
        navController = navHostController,
        startDestination = Graph.START
    ) {
        addStartTopLevel(navHostController)
        addAuthTopLevel(navHostController)
        composable(route = Graph.MAIN) {
            MainScreen()
        }
    }
}

object Graph {
    const val ROOT = "root"
    const val START = "start"
    const val AUTH = "auth"
    const val MAIN = "main"
}