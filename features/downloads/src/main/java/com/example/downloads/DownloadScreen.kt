package com.example.downloads

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.designsystem.Background
import com.example.designsystem.Primary
import com.example.designsystem.R
import com.example.designsystem.components.JetHeading
import com.example.designsystem.components.JetText

@Composable
fun DownloadScreen() {
    DownloadsContent()
}

@Composable
private fun DownloadsContent() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ) {
                JetHeading(title = "دانلود های من", hasCartIcon = true)
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(11f)
            ) {
//                when (val state = uiState?.ordersUiState) {
//                    OrdersUiState.Loading -> {
//                        Column(modifier = Modifier
//                            .fillMaxSize(),
//                            verticalArrangement = Arrangement.Center,
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//                            JetText(text = "در حال بارگذاری ...")
//                        }
//                    }
//                    is OrdersUiState.Success -> {
//                        LazyColumn(
//                            userScrollEnabled = true,
//                            verticalArrangement = Arrangement.spacedBy(10.dp),
//                            contentPadding = PaddingValues(0.dp),
//                            content = {
//                                items(count = 5) { position ->
//                                    if (state.orders.isEmpty()) {
//                                        Column(modifier = Modifier
//                                            .fillMaxSize(),
//                                            verticalArrangement = Arrangement.Center,
//                                            horizontalAlignment = Alignment.CenterHorizontally
//                                        ) {
//                                            JetText(text = "هیچ سفارشی یافت نشد!")
//                                        }
//                                    } else {
//                                        OrderItem()
//                                    }
//                                }
//                            }
//                        )
//                    }
//                    is OrdersUiState.Error -> {
//                        Column(modifier = Modifier
//                            .fillMaxSize(),
//                            verticalArrangement = Arrangement.Center,
//                            horizontalAlignment = Alignment.CenterHorizontally
//                        ) {
//                            JetText(text = state.message)
//                        }
//                    }
//                    else -> Unit
//                }
                LazyColumn(
                    userScrollEnabled = true,
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    contentPadding = PaddingValues(0.dp),
                    content = {
                        items(count = 5) { position ->
                            DownloadItem()
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun DownloadItem() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(90.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1.2f),
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.jetminds_shop_feature_image_example),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(2.7f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                JetText(
                    text = "سورس کد پروژه اندروید Jet OnBoarding Modern",
                    fontSize = 12,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                JetText(
                    text = "49.000 تومان",
                    fontSize = 11,
                    fontWeight = FontWeight.Medium,
                    color = Primary
                )
            }

            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1.1f),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                Image(
                    painter = painterResource(id = R.drawable.download_icon),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    colorFilter = ColorFilter.tint(color = Primary)
                )
            }
        }
    }
}

@Preview
@Composable
fun Preview_DownloadScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        DownloadsContent()
    }
}