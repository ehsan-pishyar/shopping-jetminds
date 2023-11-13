/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/1/23, 1:22 PM
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

package com.example.shoppingjetminds.navigation.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.example.login.navigation.loginScreen
import com.example.navigation.AuthScreens
import com.example.navigation.Graph

fun NavGraphBuilder.addAuthTopLevel(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreens.Login.route
    ) {
        loginScreen(navController)
    }
}