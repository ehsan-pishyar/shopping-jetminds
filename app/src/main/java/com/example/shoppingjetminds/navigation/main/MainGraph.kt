package com.example.shoppingjetminds.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shoppingjetminds.navigation.BottomNavigationScreens
import com.example.shoppingjetminds.navigation.Graph
import com.example.shoppingjetminds.views.main.CartScreen
import com.example.shoppingjetminds.views.main.CategoryScreen
import com.example.shoppingjetminds.views.main.FavoritesScreen
import com.example.shoppingjetminds.views.main.HomeScreen
import com.example.shoppingjetminds.views.main.ShopScreen

@Composable
fun MainGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = BottomNavigationScreens.Home.route
    ) {
        composable(route = BottomNavigationScreens.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = BottomNavigationScreens.Shop.route) {
            ShopScreen()
        }
        composable(route = BottomNavigationScreens.Category.route) {
            CategoryScreen()
        }
        composable(route = BottomNavigationScreens.Favorites.route) {
            FavoritesScreen()
        }
        composable(route = BottomNavigationScreens.Cart.route) {
            CartScreen()
        }
    }
}