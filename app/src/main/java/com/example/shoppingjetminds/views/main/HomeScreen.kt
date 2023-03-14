package com.example.shoppingjetminds.views.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.ui.theme.Background

@Composable
fun HomeScreen(
    // productCategoriesViewModel: ProductCategoriesViewModel = hiltViewModel()
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .background(Background)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Banner
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(230.dp)
                .background(Color(0xFFf6f6f6))
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Image(painter = painterResource(id = R.drawable.image_placeholder), contentDescription = "main banner")
                }
            }

            // Categories

            // OffSale Products
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}