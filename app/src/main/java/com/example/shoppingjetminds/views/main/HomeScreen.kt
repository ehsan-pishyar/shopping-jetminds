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
import androidx.navigation.NavController
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.components.JetHomeHeading
import com.example.shoppingjetminds.components.JetIconText
import com.example.shoppingjetminds.components.JetProduct
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.uistates.AndroidUiState
import com.example.shoppingjetminds.viewmodels.TestUiState
import com.example.shoppingjetminds.viewmodels.TestViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    testViewModel: TestViewModel = hiltViewModel()
){
    val testUiState: TestUiState by testViewModel.testState.collectAsState()

    HomeContent(
        testState = testUiState
    )
}

@Composable
private fun HomeContent(
    testState: TestUiState? = null
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
                    toProfileScreen = {},
                    toCartScreen = {},
                    toNotificationScreen = {}
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
            if (testState != null) {
                AndroidSourceCodeSection(testUiState = testState)
            }

            SectionSpacer()

            // Android Source Code
            ApplicationUiKitSection()

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
            Illustrations3DSection()
        }
    }
}

@Composable
private fun AndroidSourceCodeSection(
    testUiState: TestUiState
) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ProductsHeadingSection(title = "سورس کد اندروید")
        when (val androidUiState = testUiState.testState) {
            AndroidUiState.Loading -> {
                JetText(text = "در حال باگذاری ...")
            }
            is AndroidUiState.Success -> {
                LazyRow(
                    contentPadding = PaddingValues(0.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true,
                    content = {
                        items(count = 5) { position ->
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
private fun ApplicationUiKitSection() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ProductsHeadingSection(title = "رابط کاربری اپلیکیشن")
        LazyRow(
            contentPadding = PaddingValues(0.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            userScrollEnabled = true,
            content = {
                items(count = 5) { position ->
                    JetProduct(title = "رابط کاربری اپلیکیشن فروشگاهی اندروید JetMinds")
                }
            }
        )
    }
}

@Composable
private fun Illustrations3DSection() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        ProductsHeadingSection(title = "طرح های سه بعدی")
        LazyRow(
            contentPadding = PaddingValues(0.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            userScrollEnabled = true,
            content = {
                items(count = 5) { position ->
                    JetProduct(title = "رابط کاربری اپلیکیشن فروشگاهی اندروید JetMinds")
                }
            }
        )
    }
}

@Composable
private fun ProductsHeadingSection(
    title: String
) {
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        JetText(text = title)
        JetIconText {}
    }
}

@Composable
private fun SectionSpacer(value: Int = 20) {
    Spacer(modifier = Modifier.height(value.dp))
}


@Preview
@Composable
fun Preview_HomeScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        HomeContent()
    }
}