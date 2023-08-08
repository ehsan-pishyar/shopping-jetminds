package com.example.shoppingjetminds.views.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
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
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.components.JetHomeHeading
import com.example.shoppingjetminds.components.JetIconText
import com.example.shoppingjetminds.components.JetProduct
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.uistates.AndroidUiState
import com.example.shoppingjetminds.uistates.ApplicationUiKitUiState
import com.example.shoppingjetminds.uistates.HomeUiState
import com.example.shoppingjetminds.uistates.Illustrations3DUiState
import com.example.shoppingjetminds.viewmodels.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    toCartScreen: () -> Unit,
    toNotificationScreen: () -> Unit,
    toProfileScreen: () -> Unit,
    toShopScreen: () -> Unit
){
    val homeUiState: HomeUiState by viewModel.homeUiState.collectAsState()

    HomeContent(
        homeUiState = homeUiState,
        toCartScreen = { toCartScreen() },
        toNotificationScreen = { toNotificationScreen() },
        toProfileScreen = { toProfileScreen() },
        toShopScreen = { toShopScreen() }
    )
}

@Composable
private fun HomeContent(
    homeUiState: HomeUiState? = null,
    toCartScreen: () -> Unit,
    toNotificationScreen: () -> Unit,
    toProfileScreen: () -> Unit,
    toShopScreen: () -> Unit
) {
    val scrollState = rememberScrollState()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .verticalScroll(state = scrollState, enabled = true)
        ) {

            // Heading
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
                verticalArrangement = Arrangement.Top
            ) {
                JetHomeHeading(
                    toProfileScreen = { toProfileScreen() }, // TODO: Handle toProfileScreen Click
                    toCartScreen = { toCartScreen() },
                    toNotificationScreen = { toNotificationScreen() } // TODO: Handle toNotificationScreen Click
                )
            }

            // Main slider
            Image(
                painter = painterResource(id = R.drawable.jetminds_slider_1),
                contentDescription = "slider",
                modifier = Modifier.clip(shape = RoundedCornerShape(12.dp))
            )

            SectionSpacer()

            // Application UI Kit
            if (homeUiState != null) {
                AndroidSourceCodeSection(
                    homeUiState = homeUiState,
                    toShopScreen = { toShopScreen() }
                )
            }

            SectionSpacer()

            // Android Source Code
            ApplicationUiKitSection(
                homeUiState = homeUiState!!,
                toShopScreen = { toShopScreen() }
            )

            SectionSpacer()

            // Illustration banner
            Image(
                painter = painterResource(id = R.drawable.illustrations_3d_banner),
                contentDescription = "3d illustration banner",
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(12.dp))
            )

            SectionSpacer()

            // 3D illustration products
            Illustrations3DSection(
                homeUiState = homeUiState,
                toShopScreen = { toShopScreen() }
            )
        }
    }
}

@Composable
private fun AndroidSourceCodeSection(
    homeUiState: HomeUiState,
    toShopScreen: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ProductsHeadingSection(
            title = "سورس کد اندروید",
            toShopScreen = { toShopScreen() }
        )
        when (val androidUiState = homeUiState.androidUiState) {
            AndroidUiState.Loading -> {
                JetText(text = "در حال باگذاری ...")
            }
            is AndroidUiState.Success -> {
                LazyRow(
                    contentPadding = PaddingValues(0.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true,
                    content = {
                        items(count = androidUiState.androidSourceCodes.size) { position ->
                            JetProduct(
                                title = "${androidUiState.androidSourceCodes[position].name}",
                                image = androidUiState.androidSourceCodes[position].images?.get(0)?.src,
                                price = androidUiState.androidSourceCodes[position].price,
                                rating = androidUiState.androidSourceCodes[position].averageRating,
                                category = androidUiState.androidSourceCodes[position].categories?.get(0)?.name
                            )
                        }
                    }
                )
            }
            is AndroidUiState.Error -> {
                JetText(text = "${androidUiState.message}")
            }
        }
    }
}

@Composable
private fun ApplicationUiKitSection(
    homeUiState: HomeUiState,
    toShopScreen: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ProductsHeadingSection(
            title = "رابط کاربری اپلیکیشن",
            toShopScreen = { toShopScreen() }
        )
        when (val applicationUiKitUiState = homeUiState.applicationUiKitUiState) {
            ApplicationUiKitUiState.Loading -> {
                JetText(text = "در حال باگذاری ...")
            }
            is ApplicationUiKitUiState.Success -> {
                LazyRow(
                    contentPadding = PaddingValues(0.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true,
                    content = {
                        items(count = applicationUiKitUiState.applicationUiKits.size) { position ->
                            JetProduct(
                                title = "${applicationUiKitUiState.applicationUiKits[position].name}",
                                image = applicationUiKitUiState.applicationUiKits[position].images?.get(0)?.src,
                                price = applicationUiKitUiState.applicationUiKits[position].price,
                                rating = applicationUiKitUiState.applicationUiKits[position].averageRating,
                                category = applicationUiKitUiState.applicationUiKits[position].categories?.get(0)?.name
                            )
                        }
                    }
                )
            }
            is ApplicationUiKitUiState.Error -> {
                JetText(text = "${applicationUiKitUiState.message}")
            }
        }
    }
}

@Composable
private fun Illustrations3DSection(
    homeUiState: HomeUiState,
    toShopScreen: () -> Unit
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ProductsHeadingSection(
            title = "طرح های سه بعدی",
            toShopScreen = { toShopScreen() }
        )
        when (val illustrations3DUiState = homeUiState.illustrations3DUiState) {
            Illustrations3DUiState.Loading -> {
                JetText(text = "در حال باگذاری ...")
            }
            is Illustrations3DUiState.Success -> {
                LazyRow(
                    contentPadding = PaddingValues(0.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true,
                    content = {
                        items(count = illustrations3DUiState.illustration3Ds.size) { position ->
                            JetProduct(
                                title = "${illustrations3DUiState.illustration3Ds[position].name}",
                                image = illustrations3DUiState.illustration3Ds[position].images?.get(0)?.src,
                                price = illustrations3DUiState.illustration3Ds[position].price,
                                rating = illustrations3DUiState.illustration3Ds[position].averageRating,
                                category = illustrations3DUiState.illustration3Ds[position].categories?.get(0)?.name
                            )
                        }
                    }
                )
            }
            is Illustrations3DUiState.Error -> {
                JetText(text = "${illustrations3DUiState.message}")
            }
        }
    }
}

@Composable
private fun ProductsHeadingSection(
    title: String,
    toShopScreen: () -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        JetText(text = title)
        JetIconText {
            toShopScreen()
        }
    }
}

@Composable
private fun SectionSpacer(value: Int = 20) {
    Spacer(modifier = Modifier.height(value.dp))
}


@Preview
@Composable
fun Preview_HomeScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        HomeContent(
            toCartScreen = {},
            toNotificationScreen = {},
            toProfileScreen = {},
            toShopScreen = {}
        )
    }
}