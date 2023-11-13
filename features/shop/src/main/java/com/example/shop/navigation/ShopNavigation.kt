/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/10/23, 10:34 PM
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

package com.example.shop.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.core.utils.SharedViewModel
import com.example.navigation.BottomNavigationScreens
import com.example.navigation.DetailScreens
import com.example.navigation.OtherScreens
import com.example.navigation.PaymentScreens
import com.example.shop.ShopScreen

fun NavGraphBuilder.shopScreen(
    navController: NavHostController,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = BottomNavigationScreens.Shop.route
    ) {
        ShopScreen(
            sharedViewModel = sharedViewModel,
            toCartScreen = { navController.navigate(route = PaymentScreens.Cart.route) },
            toProductDetailsScreen = { navController.navigate(route = DetailScreens.ProductDetails.route) },
            toSearchScreen = { navController.navigate(route = OtherScreens.Search.route) },
            toNotificationScreen = { navController.navigate(route = OtherScreens.Notifications.route) }
        )
    }
}