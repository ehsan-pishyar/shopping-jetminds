package com.example.navigation

import com.example.designsystem.R

sealed class BottomNavigationScreens(
    val route: String,
    val title: String,
    val icon: Int
) {
    object Home: BottomNavigationScreens(
        route = "home",
        title = "خانه",
        icon = R.drawable.home
    )

    object Shop: BottomNavigationScreens(
        route = "shop",
        title = "فروشگاه",
        icon = R.drawable.shop
    )

    object Category: BottomNavigationScreens(
        route = "category",
        title = "دسته بندی",
        icon = R.drawable.category
    )

    object Favorites: BottomNavigationScreens(
        route = "favorites",
        title = "علاقمندی",
        icon = R.drawable.favorite
    )

    object Cart: BottomNavigationScreens(
        route = "cart",
        title = "سبد خرید",
        icon = R.drawable.cart
    )
}
