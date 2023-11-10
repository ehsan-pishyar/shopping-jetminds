package com.example.category

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.utils.SharedViewModel
import com.example.designsystem.Background
import com.example.designsystem.R
import com.example.designsystem.components.JetCategory
import com.example.designsystem.components.JetHeading
import com.example.designsystem.components.JetText

@Composable
fun CategoryScreen(
    viewModel: ProductCategoriesViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = SharedViewModel(),
    toCartScreen: () -> Unit,
    toShopScreen: () -> Unit
){
    val categoryState: MainProductCategoriesUiState by viewModel.categoriesState.collectAsState()
    val cartTotalCountState by viewModel.cartTotalCountState.collectAsState()

    CategoryScreenContent(
        categoryState = categoryState,
        sharedViewModel = sharedViewModel,
        cartTotalCountState = cartTotalCountState,
        toCartScreen = { toCartScreen() },
        toShopScreen = { toShopScreen() }
    )
}

@Composable
private fun CategoryScreenContent(
    categoryState: MainProductCategoriesUiState? = null,
    sharedViewModel: SharedViewModel? = null,
    cartTotalCountState: Int = 0,
    toCartScreen: () -> Unit,
    toShopScreen: () -> Unit
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
                    title = stringResource(id = R.string.heading_product_category),
                    hasCartIcon = true,
                    toCartScreen = { toCartScreen() },
                    cartItemSize = cartTotalCountState
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(11f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    when(val state = categoryState?.categoriesUiState) {
                        ProductCategoriesUiState.Loading -> {
                            JetText(text = stringResource(id = R.string.loading))
                        }
                        is ProductCategoriesUiState.Success -> {
                            LazyColumn(modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                                verticalArrangement = Arrangement.spacedBy(10.dp),
                                userScrollEnabled = true
                            ) {
                                items(count = state.categories.size) { position ->
                                    JetCategory(
                                        imagePath = state.categories[position].image?.src,
                                        title = state.categories[position].name!!,
                                        onCategoryClick = {
                                            sharedViewModel?.addCategoryId(state.categories[position].id!!)
                                            toShopScreen()
                                        }
                                    )
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
        CategoryScreenContent(
            toCartScreen = {},
            toShopScreen = {}
        )
    }
}