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

package com.example.shoppingjetminds.navigation.start

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigation
import com.example.navigation.Graph
import com.example.navigation.StartScreens
import com.example.onboarding.navigation.onBoardingScreen
import com.example.splash.navigation.splashScreen

fun NavGraphBuilder.addStartTopLevel(navController: NavHostController) {
    navigation(
        route = Graph.START,
        startDestination = StartScreens.Splash.route
    ) {
        splashScreen(navController = navController)
        onBoardingScreen(navController = navController)
    }
}