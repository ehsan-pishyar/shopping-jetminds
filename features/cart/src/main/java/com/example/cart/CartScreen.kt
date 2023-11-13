/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/11/23, 2:07 PM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.utils.SharedViewModel
import com.example.designsystem.Background
import com.example.designsystem.BlackColor
import com.example.designsystem.LighterBlack
import com.example.designsystem.LighterGray
import com.example.designsystem.Primary
import com.example.designsystem.R
import com.example.designsystem.RedColor
import com.example.designsystem.components.CartListItem
import com.example.designsystem.components.JetHeading
import com.example.designsystem.components.JetPriceText
import com.example.designsystem.components.JetSimpleButton
import com.example.designsystem.components.JetText
import com.example.designsystem.components.JetTextField
import com.example.domain.models.Cart

@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = SharedViewModel(),
    toProductDetailsScreen: () -> Unit
) {
    val cartUiState: MainCartUiState by viewModel.cartUiState.collectAsState()
    val cartTotalCountState by viewModel.cartTotalCountState.collectAsState()
    val isInCartState by viewModel.isInCartState.collectAsState()
    val subTotalState by viewModel.subTotalPrice.collectAsState()

    CartContent(
        viewModel = viewModel,
        cartUiState = cartUiState,
        cartTotalCountState = cartTotalCountState,
        isInCartState = isInCartState,
        sharedViewModel = sharedViewModel,
        toProductDetailsScreen = toProductDetailsScreen,
        subTotalState = subTotalState
    )
}

@Composable
private fun CartContent(
    viewModel: CartViewModel,
    cartUiState: MainCartUiState,
    cartTotalCountState: Int = 0,
    isInCartState: Int = 0,
    sharedViewModel: SharedViewModel,
    toProductDetailsScreen: () -> Unit,
    subTotalState: Int = 0
) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 15.dp,
                start = 15.dp,
                end = 15.dp,
                bottom = 70.dp
            )
        ) {

            // Check if cart is empty or not
            when (cartTotalCountState) {
                0 -> {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                    ) {
                        JetHeading(
                            title = stringResource(id = R.string.heading_cart),
                            hasCartIcon = true,
                            cartItemSize = cartTotalCountState
                        )
                    }
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(11f)
                    ) {
                        CartItemNotFound()
                    }
                }
                else -> {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                    ) {
                        JetHeading(
                            title = stringResource(id = R.string.heading_cart),
                            hasCartIcon = true,
                            cartItemSize = cartTotalCountState
                        )
                    }
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(6f),
                        verticalArrangement = Arrangement.Top
                    ) {
                        CartList(
                            items = cartUiState.cartUiState,
                            sharedViewModel = sharedViewModel,
                            toProductDetailsScreen = toProductDetailsScreen,
                            viewModel = viewModel
                        )
                    }
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                    ) {
                        PromoSection()
                    }
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(4f)
                    ) {
                        CheckoutSection(
                            viewModel = viewModel,
                            subTotalState = subTotalState,
                            cartItemCountState = cartTotalCountState
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CartList(
    viewModel: CartViewModel,
    items: List<Cart>,
    sharedViewModel: SharedViewModel,
    toProductDetailsScreen: () -> Unit
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp),
        content = {
        items(count = items.size) { position ->
            CartListItem(
                image = "${items[position].productImage}",
                title = "${items[position].productTitle}",
                category = "${items[position].productCategory}",
                price = "${items[position].productPrice}",
                onProductClick = {
//                    sharedViewModel.addProduct(items[position])
//                    toProductDetailsScreen()
                },
                onDeleteItemClick = {
                    viewModel.deleteCartItem(items[position].productId!!)
                }
            )
        }
    })
}

@Composable
fun PromoSection() {
    Row(modifier = Modifier
        .fillMaxSize(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(3.8f),
            verticalArrangement = Arrangement.Top
        ) {
            JetTextField(
                placeholder = stringResource(id = R.string.coupon_code),
                onValueChange = {},
                height = 56,
                shape = 12,
                singleLine = true,
                modifier = Modifier.wrapContentWidth()
            )
        }

        // Promo button
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(1.2f),
            verticalArrangement = Arrangement.Top
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                JetText(
                    text = stringResource(id = R.string.apply_coupon_code),
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun CheckoutSection(
    viewModel: CartViewModel,
    subTotalState: Int = 0,
    cartItemCountState: Int = 0
) {
    val taxState by viewModel.calculateTaxState.collectAsState()
    val totalPriceState by viewModel.calculateTotalPriceState.collectAsState()

    Card(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    JetText(
                        text = stringResource(id = R.string.sub_total_sum),
                        fontSize = 14,
                        fontWeight = FontWeight.SemiBold
                    )
                    JetPriceText(
                        price = "$subTotalState",
                        priceTextSize = 12,
                        priceTomanSize = 13,
                        priceFreeSize = 12,
                        color = BlackColor
                    )
                }

                Divider()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    JetText(
                        text = stringResource(id = R.string.tax),
                        fontSize = 14,
                        fontWeight = FontWeight.SemiBold
                    )
                    viewModel.calculateTax(subTotal = subTotalState)
                    JetPriceText(
                        price = "$taxState",
                        priceTextSize = 12,
                        priceTomanSize = 13,
                        priceFreeSize = 12,
                        priceTextColor = RedColor,
                        color = BlackColor
                    )
                }

                Divider()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    JetText(
                        text = stringResource(id = R.string.total_sum),
                        fontSize = 14,
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.Bottom
                    ) {
                        JetText(
                            text = "($cartItemCountState)",
                            fontSize = 12,
                            fontWeight = FontWeight.Normal,
                            color = LighterGray
                        )
                        viewModel.calculateTotalPrice(
                            subTotal = subTotalState,
                            tax = taxState
                        )
                        JetPriceText(
                            price = "$totalPriceState",
                            priceTextSize = 15,
                            priceTomanSize = 13,
                            priceFreeSize = 14
                        )
                    }
                }
            }

            Column {
                JetSimpleButton(
                    onClick = { /*TODO*/ },
                    text = stringResource(id = R.string.continue_to_checkout)
                )
            }
        }
    }
}

@Composable
private fun CartItemNotFound() {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.cart_404),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        JetText(
            text = stringResource(id = R.string.cart_404_title),
            fontWeight = FontWeight.Bold
        )

        JetText(
            text = stringResource(id = R.string.cart_404_desc),
            color = LighterBlack,
            fontSize = 12
        )
    }
}