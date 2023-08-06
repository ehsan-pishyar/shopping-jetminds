package com.example.shoppingjetminds.views.payment

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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.components.JetHeading
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.uistates.MainOrdersUiState
import com.example.shoppingjetminds.viewmodels.OrdersViewModel

@Composable
fun OrdersScreen(
    viewModel: OrdersViewModel = hiltViewModel()
) {
    val uiState: MainOrdersUiState by viewModel.orderState.collectAsState()

    OrdersContent(
        uiState = uiState
    )
}

@Composable
private fun OrdersContent(
    uiState: MainOrdersUiState? = null
) {
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
                JetHeading(title = "سفارشات من", hasCartIcon = true)
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
                            OrderItem()
                        }
                    }
                )
            }
        }
    }
}

@Composable
private fun OrderItem() {
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
                    fontWeight = FontWeight.Medium
                )
            }

            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1.1f),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                Card(modifier = Modifier
                    .wrapContentSize(),
                    shape = RoundedCornerShape(4.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Green.copy(alpha = 0.2f)
                    ),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 0.dp
                    )
                ) {
                    Column(modifier = Modifier
                        .wrapContentSize()
                        .padding(horizontal = 5.dp, vertical = 3.dp)
                    ) {
                        JetText(
                            text = "پرداخت شده",
                            fontSize = 10,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview_OrdersScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        OrdersContent()
    }
}