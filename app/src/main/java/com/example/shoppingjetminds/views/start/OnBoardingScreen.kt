package com.example.shoppingjetminds.views.start

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.shoppingjetminds.ui.theme.Background

@Composable
fun OnBoardingScreen(
    toHomeScreen: () -> Unit
){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            
        }
    }

}