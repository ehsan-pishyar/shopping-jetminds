package com.example.shoppingjetminds.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.shoppingjetminds.navigation.BottomNavigationScreens
import com.example.shoppingjetminds.navigation.DetailScreens
import com.example.shoppingjetminds.navigation.Graph
import com.example.shoppingjetminds.viewmodels.SharedViewModel
import com.example.shoppingjetminds.views.details.ProductDetailsScreen
import com.example.shoppingjetminds.views.payment.CartScreen
import com.example.shoppingjetminds.views.main.CategoryScreen
import com.example.shoppingjetminds.views.other.FavoritesScreen
import com.example.shoppingjetminds.views.main.HomeScreen
import com.example.shoppingjetminds.views.main.ShopScreen

@Composable
fun MainGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    val sharedViewModel: SharedViewModel = viewModel()

    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = BottomNavigationScreens.Home.route
    ) {
        composable(route = BottomNavigationScreens.Home.route) {
            HomeScreen(
                sharedViewModel = sharedViewModel,
                toCartScreen = { navController.navigate(BottomNavigationScreens.Cart.route) },
                toNotificationScreen = {  } ,
                toProfileScreen = {  },
                toShopScreen = { navController.navigate(BottomNavigationScreens.Shop.route) },
                toProductDetailsScreen = { navController.navigate(DetailScreens.ProductDetails.route) }
            )
        }
        composable(route = BottomNavigationScreens.Shop.route) {
            ShopScreen(
                sharedViewModel = sharedViewModel,
                toCartScreen = { navController.navigate(BottomNavigationScreens.Cart.route) },
                toProductDetailsScreen = { navController.navigate(DetailScreens.ProductDetails.route) }
            )
        }
        composable(route = BottomNavigationScreens.Category.route) {
            CategoryScreen(
                toCartScreen = { navController.navigate(BottomNavigationScreens.Cart.route) }
            )
        }
        composable(route = BottomNavigationScreens.Favorites.route) {
            FavoritesScreen()
        }
        composable(route = BottomNavigationScreens.Cart.route) {
            CartScreen()
        }
        composable(route = DetailScreens.ProductDetails.route) {
            ProductDetailsScreen(
                sharedViewModel = sharedViewModel,
                toCartScreen = { navController.navigate(BottomNavigationScreens.Cart.route) }
            )
        }
    }
}