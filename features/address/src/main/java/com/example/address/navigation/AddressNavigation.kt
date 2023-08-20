package com.example.address.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.address.AddressScreen
import com.example.navigation.OtherScreens

fun NavGraphBuilder.addressScreen(navController: NavHostController) {
    composable(
        route = OtherScreens.Address.route
    ) {
        AddressScreen()
    }
}