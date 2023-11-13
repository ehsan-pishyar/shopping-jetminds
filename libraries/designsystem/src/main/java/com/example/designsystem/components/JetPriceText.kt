/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/11/23, 1:26 AM
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

package com.example.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.utils.priceThousandsSeparator
import com.example.designsystem.Primary

@Composable
fun JetPriceText(
    price: String = "",
    priceTextSize: Int = 14,
    priceTomanSize: Int = 10,
    priceFreeSize: Int = 12,
    color: Color = Primary,
    priceTextColor: Color = Primary
) {
    if (price.trim().isEmpty() || price == "0") {
        JetText(
            text = "رایگان",
            color = color,
            fontWeight = FontWeight.SemiBold,
            fontSize = priceFreeSize
        )
    } else {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            JetText(
                text = priceThousandsSeparator(price),
                color = priceTextColor,
                fontWeight = FontWeight.SemiBold,
                fontSize = priceTextSize
            )
            JetText(
                text = "تومان",
                color = color,
                fontWeight = FontWeight.SemiBold,
                fontSize = priceTomanSize
            )
        }
    }
}

@Preview
@Composable
private fun Preview_JetPriceText() {
    JetPriceText(
        price = "",
        priceTextSize = 14,
        priceTomanSize = 10,
        priceFreeSize = 12,
        color = Primary
    )
}