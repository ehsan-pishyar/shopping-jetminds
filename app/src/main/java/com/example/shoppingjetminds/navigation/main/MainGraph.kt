/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/10/23, 10:35 PM
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

package com.example.shoppingjetminds.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.account.navigation.accountScreen
import com.example.address.navigation.addressScreen
import com.example.billing.navigation.billingScreen
import com.example.navigation.BottomNavigationScreens
import com.example.navigation.Graph
import com.example.cart.navigation.cartScreen
import com.example.category.navigation.categoryScreen
import com.example.checkout.navigation.checkoutScreen
import com.example.compare.navigation.compareScreen
import com.example.core.utils.SharedViewModel
import com.example.downloads.navigation.downloadsScreen
import com.example.favorites.navigation.favoritesScreen
import com.example.home.navigation.homeScreen
import com.example.login.navigation.loginScreen
import com.example.notifications.navigation.notificationsScreen
import com.example.orders.navigation.ordersScreen
import com.example.productdetails.navigation.productDetailsScreen
import com.example.search.navigation.searchScreen
import com.example.shop.navigation.shopScreen
import com.example.userinformations.navigation.userInformationScreen

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
        homeScreen(
            navController = navController,
            sharedViewModel = sharedViewModel
        )
        shopScreen(
            navController = navController,
            sharedViewModel = sharedViewModel
        )
        categoryScreen(
            navController = navController,
            sharedViewModel = sharedViewModel
        )
        favoritesScreen(
            navController = navController,
            sharedViewModel = sharedViewModel
        )
        cartScreen(
            navController = navController,
            sharedViewModel = sharedViewModel
        )

        productDetailsScreen(
            sharedViewModel = sharedViewModel,
            navController = navController
        )
        
        compareScreen(navController = navController)
        searchScreen(
            navController = navController,
            sharedViewModel = sharedViewModel
        )
        addressScreen(navController = navController)
        downloadsScreen(navController = navController)
        notificationsScreen(navController = navController)

        billingScreen(navController = navController)
        checkoutScreen(navController = navController)
        ordersScreen(navController = navController)

        loginScreen(navController = navController)
        accountScreen(navController = navController)
        userInformationScreen(navController = navController)
    }
}