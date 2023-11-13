/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/9/23, 1:08 PM
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

package com.example.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.designsystem.Background
import com.example.designsystem.LighterGray
import com.example.navigation.StartScreens
import kotlinx.coroutines.delay
import com.example.designsystem.R
import com.example.designsystem.components.JetText

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    toOnBoardingScreen: () -> Unit,
    toHomeScreen: () -> Unit,
    toLoginScreen: () -> Unit
){
    // AnimationEffect
    LaunchedEffect(key1 = true) {
        delay(1000L)

        !viewModel.isLoading.value

        if (viewModel.startDestination.value == StartScreens.OnBoarding.route) {
            toOnBoardingScreen()
        } else {
            toHomeScreen()
//            toLoginScreen()
        }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
        ) {}
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(10f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.width(120.dp),
                painter = painterResource(id = R.drawable.jetminds_fav_icon),
                contentDescription = "logo"
            )
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .padding(15.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JetText(
                text = stringResource(id = R.string.company_name),
                fontSize = 14,
                color = LighterGray
            )
        }
    }
}