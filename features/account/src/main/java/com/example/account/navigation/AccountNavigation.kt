/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 8/15/23, 6:49 PM
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