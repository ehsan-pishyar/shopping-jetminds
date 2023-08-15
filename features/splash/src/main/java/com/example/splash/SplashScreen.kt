package com.example.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.designsystem.Background
import com.example.navigation.StartScreens
import kotlinx.coroutines.delay
import com.example.designsystem.R

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    toOnBoardingScreen: () -> Unit,
    toHomeScreen: () -> Unit
){
    // AnimationEffect
    LaunchedEffect(key1 = true) {
        delay(1000L)

        !viewModel.isLoading.value

        if (viewModel.startDestination.value == StartScreens.OnBoarding.route) {
            toOnBoardingScreen()
        } else {
            toHomeScreen()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Background),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.width(120.dp),
            painter = painterResource(id = R.drawable.jetminds_fav_icon),
            contentDescription = "logo"
        )
    }
}