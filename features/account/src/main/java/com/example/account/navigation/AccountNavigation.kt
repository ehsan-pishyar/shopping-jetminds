package com.example.account.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.account.AccountScreen
import com.example.navigation.AuthScreens
import com.example.navigation.Graph

fun NavGraphBuilder.accountScreen(navController: NavHostController) {
    composable(
        route = AuthScreens.Account.route
    ) {
        AccountScreen(
            toUserInformationScreen = {  },
            toOrdersScreen = {  },
            toDownloadScreen = {  },
            toBillingScreen = {  },
            toAddressScreen = {  },
            toFavoritesScreen = {  },
            toHomeScreen = { navController.navigate(Graph.MAIN) }
        )
    }
}