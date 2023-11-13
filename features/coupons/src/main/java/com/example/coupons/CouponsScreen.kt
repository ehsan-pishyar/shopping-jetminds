/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/1/23, 11:55 PM
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

package com.example.coupons

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.designsystem.Background
import com.example.designsystem.LighterBlack
import com.example.designsystem.Primary
import com.example.designsystem.R
import com.example.designsystem.components.JetText
import com.example.domain.models.CouponsResponse

@Composable
fun CouponsScreen(
    viewModel: CouponsViewModel = hiltViewModel()
) {
    val uiState: MainCouponsUiState by viewModel.couponsState.collectAsState()

    CouponsContent(uiState =  uiState)
}

@Composable
private fun CouponsContent(
    uiState: MainCouponsUiState? = null
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ) {

            when (val state = uiState?.couponsUiState) {
                CouponsUiState.Loading -> {
                    Column(modifier = Modifier
                        .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        JetText(text = "در حال بارگذاری ...")
                    }
                }
                is CouponsUiState.Success -> {
                    if (state.coupons.isEmpty()) {
                        CouponsNotFound()
                    } else {
                        CouponsList(state.coupons)
                    }
                }
                is CouponsUiState.Error -> {
                    Column(modifier = Modifier
                        .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        JetText(text = state.message)
                    }
                }
                else -> {
                    CouponsNotFound()
                }
            }
        }
    }
}

@Composable
private fun CouponsNotFound() {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.coupon),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        JetText(
            text = "کد تخفیفی یافت نشد",
            fontWeight = FontWeight.Bold
        )

        JetText(
            text = "در حال حاضر هیچ کد تخفیفی برای ازائه وجود ندارد",
            color = LighterBlack,
            fontSize = 12
        )
    }
}

@Composable
private fun CouponsRowItem(coupon: CouponsResponse) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(70.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(3f),
                verticalArrangement = Arrangement.Center
            ) {
                JetText(
                    text = "${coupon.code}",
                    fontSize = 16,
                    fontWeight = FontWeight.SemiBold,
                    color = Primary,
                    fontFamily = FontFamily.Default
                )
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(0.2f)
            ) {

            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1.5f),
                verticalArrangement = Arrangement.Center
            ) {
                JetText(
                    text = "${coupon.amount}",
                    fontSize = 25,
                    fontWeight = FontWeight.SemiBold,
                    color = Primary,
                )
            }
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(5.3f),
                verticalArrangement = Arrangement.Center
            ) {
                JetText(
                    text = "${coupon.description}",
                    fontSize = 13
                )
            }
        }
    }
}

@Composable
private fun CouponsList(coupons: List<CouponsResponse>) {
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        userScrollEnabled = true
    ) {
        items(count = coupons.size) { position ->
            CouponsRowItem(
                coupon = coupons[position]
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_CouponsScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        CouponsContent()
    }
}