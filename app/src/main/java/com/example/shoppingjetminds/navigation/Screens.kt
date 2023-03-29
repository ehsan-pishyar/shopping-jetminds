package com.example.shoppingjetminds.navigation

sealed class StartScreens(val route: String) {
    object Splash: StartScreens(route = "splash")
    object OnBoarding: StartScreens(route = "on_boarding")
}

sealed class AuthScreens(val route: String) {
    object Login: AuthScreens(route = "login")
    object Verification: AuthScreens(route = "verification")
}

sealed class MainScreens(val route: String) {
    object Home: MainScreens(route = "home")
    object Shop: MainScreens(route = "shop")
    object Category: MainScreens(route = "category")
    object Favorites: MainScreens(route = "favorites")
    object Account: MainScreens(route = "account")
}
