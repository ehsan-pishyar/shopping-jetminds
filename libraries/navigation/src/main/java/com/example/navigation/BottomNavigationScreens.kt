/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/15/23, 8:42 PM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
