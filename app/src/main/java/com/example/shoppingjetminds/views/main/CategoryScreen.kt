package com.example.shoppingjetminds.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.components.JetCategory
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.viewmodels.HomeScreenProductCategoriesUiState
import com.example.shoppingjetminds.viewmodels.ProductCategoriesViewModel

@Composable
fun CategoryScreen(
    viewModel: ProductCategoriesViewModel = hiltViewModel()
){

    val categoryState: HomeScreenProductCategoriesUiState by viewModel.categoriesState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
//            if (uiState.loading) {
//                JetText(text = "در حال بارگذاری ...")
//            } else if (uiState.success.isNotEmpty()) {
//                JetText(text = uiState.success[0].name)
//            } else {
//                JetText(text = uiState.error)
//            }

            LazyColumn(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(count = 5) {
                    JetCategory(
                        image = R.drawable.jetminds_shop_feature_image_example,
                        title = "رابط کاربری اپلیکیشن"
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview_CategoryScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        CategoryScreen()
    }
}