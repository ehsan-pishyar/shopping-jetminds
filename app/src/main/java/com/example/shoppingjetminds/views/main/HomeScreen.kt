package com.example.shoppingjetminds.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.shoppingjetminds.components.JetProduct
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.viewmodels.HomeUiState
import com.example.shoppingjetminds.viewmodels.ProductsViewModel
import com.example.shoppingjetminds.viewmodels.NewestProductUiState

@Composable
fun HomeScreen(
    navController: NavController,
    productsViewModel: ProductsViewModel = hiltViewModel()
){

    val uiState: HomeUiState by productsViewModel.newestUiState.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .background(Background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (val state = uiState.newestProductList) {
                NewestProductUiState.Loading -> {
                    Text(
                        text = "در حال بارگزاری ...",
                        color = Color.Black,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                is NewestProductUiState.Success -> {
                    Text(
                        text = state.data[0].name,
                        color = Color.Black,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                is NewestProductUiState.Error -> {
                    Text(
                        text = state.toString(),
                        color = Color.Black,
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun Ui8ProductsSection(ui8State: NewestProductUiState) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        userScrollEnabled = true
    ) {
        when (ui8State) {
            NewestProductUiState.Loading -> {
                item {
                    JetText(text = "در حال بارگذاری محصولات ...")
                }
            }
            is NewestProductUiState.Success -> {
                items(ui8State.data.size) {
                    JetProduct(
                        title = ui8State.data[it].name,
                        image = ui8State.data[it].images[0].src,
                        price = ui8State.data[it].price,
                        rating = ui8State.data[it].averageRating,
                        category = ui8State.data[it].categories[0].name
                    )
                }
            }
            is NewestProductUiState.Error -> {
                item {
                    Column {
                        JetText(
                            text = "message: ${ui8State.throwable?.message} ",
                            maxLines = 10,
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                        )
                        JetText(
                            text = "cause: ${ui8State.throwable?.cause} ",
                            maxLines = 10,
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                        )
                        JetText(
                            text = "localizedMessage: ${ui8State.throwable?.localizedMessage}",
                            maxLines = 10,
                            modifier = Modifier
                                .wrapContentHeight()
                                .fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SectionSpacer(value: Int) {
    Spacer(modifier = Modifier.height(value.dp))
}


@Preview
@Composable
fun Preview_HomeScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {}
}