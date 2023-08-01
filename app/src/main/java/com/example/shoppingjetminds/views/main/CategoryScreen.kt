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
import com.example.shoppingjetminds.components.JetCategory
import com.example.shoppingjetminds.components.JetHeading
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.uistates.MainProductCategoriesUiState
import com.example.shoppingjetminds.uistates.ProductCategoriesUiState
import com.example.shoppingjetminds.viewmodels.ProductCategoriesViewModel

@Composable
fun CategoryScreen(
    viewModel: ProductCategoriesViewModel = hiltViewModel(),
    toCartScreen: () -> Unit = {}
){
    val categoryState: MainProductCategoriesUiState by viewModel.categoriesState.collectAsState()

    CategoryScreenContent(
        categoryState = categoryState,
        toCartScreen = { toCartScreen() }
    )
}

@Composable
private fun CategoryScreenContent(
    categoryState: MainProductCategoriesUiState? = null,
    toCartScreen: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ) {
                JetHeading(
                    title = "دسته بندی محصولات",
                    hasCartIcon = true,
                    toCartScreen = { toCartScreen() }
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(11f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp)
                ) {
                    when(val state = categoryState?.categoriesUiState) {
                        ProductCategoriesUiState.Loading -> {
                            JetText(text = "در حال بارگذازی ...")
                        }
                        is ProductCategoriesUiState.Success -> {
                            LazyColumn(modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                                verticalArrangement = Arrangement.spacedBy(10.dp),
                                userScrollEnabled = true
                            ) {
                                items(count = state.categories.size) { position ->
                                    state.categories[position].image?.src?.let {
                                        JetCategory(
                                            imagePath = it,
                                            title = state.categories[position].name!!
                                        )
                                    }
                                }
                            }
                        }
                        is ProductCategoriesUiState.Error -> {
                            JetText(text = state.message)
                        }
                        else -> {}
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun Preview_CategoryScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        CategoryScreenContent()
    }
}