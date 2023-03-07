package com.example.shoppingjetminds.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.viewmodels.ProductCategoriesViewModel

@Composable
fun HomeScreen(
    productCategoriesViewModel: ProductCategoriesViewModel = hiltViewModel()
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .background(Background)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}