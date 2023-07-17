package com.example.shoppingjetminds.navigation

import com.example.shoppingjetminds.R

sealed class BottomNavigationScreens(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home: BottomNavigationScreens(
        route = "home",
        title = "Home",
        icon = R.drawable.home
    )

    object Shop: BottomNavigationScreens(
        route = "shop",
        title = "Shop",
        icon = R.drawable.shop
    )

    object Category: BottomNavigationScreens(
        route = "category",
        title = "Category",
        icon = R.drawable.category
    )

    object Favorites: BottomNavigationScreens(
        route = "favorites",
        title = "Favorites",
        icon = R.drawable.favorite
    )

    object Cart: BottomNavigationScreens(
        route = "cart",
        title = "Cart",
        icon = R.drawable.cart
    )
}
