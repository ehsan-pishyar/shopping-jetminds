package com.example.shoppingjetminds.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.viewmodels.ProductCategoriesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryScreen(
    viewModel: ProductCategoriesViewModel = hiltViewModel()
){

    val uiState = viewModel.state.value

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (uiState.loading) {
                JetText(text = "در حال بارگذاری ...")
            } else if (uiState.success.isNotEmpty()) {
                JetText(text = uiState.success[0].name)
            } else {
                JetText(text = uiState.error)
            }
        }
    }
}