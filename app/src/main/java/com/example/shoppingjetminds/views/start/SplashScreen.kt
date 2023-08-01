package com.example.shoppingjetminds.views.start

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
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.navigation.StartScreens
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.viewmodels.SplashViewModel
import kotlinx.coroutines.delay

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