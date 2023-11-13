/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/29/23, 10:24 PM
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

package com.example.splash.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.navigation.Graph
import com.example.navigation.StartScreens
import com.example.splash.SplashScreen

fun NavGraphBuilder.splashScreen(
    navController: NavHostController
) {
    composable(
        route = StartScreens.Splash.route
    ) {
        SplashScreen(
            toOnBoardingScreen = {
                navController.popBackStack()
                navController.navigate(StartScreens.OnBoarding.route)
                    },
            toHomeScreen = {
                navController.popBackStack()
                navController.navigate(Graph.MAIN)
            },
            toLoginScreen = {
                navController.popBackStack()
                navController.navigate(Graph.AUTH)
            }
        )
    }
}