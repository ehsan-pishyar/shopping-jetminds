package com.example.shoppingjetminds.views.start

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.ui.theme.Background

@Composable
fun SplashScreen(
    toOnBoardingScreen: () -> Unit,
    toHomeScreen: () -> Unit
){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier.width(200.dp),
                painter = painterResource(id = R.drawable.anaram_logo),
                contentDescription = "logo"
            )
        }
    }
}

@Preview
@Composable
fun PreviewSplashScreen() {
    SplashScreen(toOnBoardingScreen = {}) {}
}