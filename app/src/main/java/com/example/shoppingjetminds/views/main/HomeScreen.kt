package com.example.shoppingjetminds.views.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.components.JetProduct
import com.example.shoppingjetminds.components.JetSectionTitle
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.viewmodels.HomeUiState
import com.example.shoppingjetminds.viewmodels.ProductsViewModel
import com.example.shoppingjetminds.viewmodels.Ui8ProductsUiState
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    productsViewModel: ProductsViewModel = hiltViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState()
){

    val errorMessage = "لطفا از متصل بودن خود به اینترنت مطمئن شوید"
    val okText = "انجام شد"

    val uiState: HomeUiState by productsViewModel.homeUiState.collectAsStateWithLifecycle()

    if (uiState.isError) {
        LaunchedEffect(scaffoldState.snackbarHostState) {
            scaffoldState.snackbarHostState.showSnackbar(
                message = errorMessage,
                actionLabel = okText
            )
            productsViewModel.onErrorConsumed()
        }
    }

    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing = uiState.isRefreshing),
            onRefresh = { /*TODO*/ },
            modifier = Modifier.padding(it)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.jetminds_slider_1),
                    contentDescription = "main Banner",
                    modifier = Modifier.clip(RoundedCornerShape(12.dp))
                )

                SectionSpacer(20)

                // UI8 section start
                JetSectionTitle(title = "کیت های رابط کاربری") {}
                SectionSpacer(10)
                Ui8ProductsSection(ui8State = uiState.ui8ProductsUiState)
                // UI Kit section end

                SectionSpacer(20)

                // Android source code section start
                JetSectionTitle(title = "سورس کد اندروید") {}

                SectionSpacer(10)

                // Android source code section end
            }
        }
    }
}

@Composable
fun Ui8ProductsSection(ui8State: Ui8ProductsUiState) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        userScrollEnabled = true
    ) {
        when (ui8State) {
            Ui8ProductsUiState.Loading -> {
                item {
                    JetText(text = "در حال بارگذاری محصولات ...")
                }
            }
            is Ui8ProductsUiState.Success -> {
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
            is Ui8ProductsUiState.Error -> {
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