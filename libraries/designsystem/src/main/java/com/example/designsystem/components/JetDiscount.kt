/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 8/14/23, 8:01 PM
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

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystem.Background
import com.example.designsystem.RedColor
import com.example.designsystem.Yekanbakh
import com.example.designsystem.R

@Composable
fun JetDiscount(
    modifier: Modifier = Modifier,
    discountAmount: Int,
    discountAmountSize: Int = 14
) {
    Box {
        Card(
            modifier = modifier.size(width = 40.dp, height = 20.dp),
            backgroundColor = RedColor,
            shape = RoundedCornerShape(3.dp)
        ) {
            Row(
                modifier = modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = modifier.wrapContentWidth(),
                    text = "$discountAmount",
                    fontSize = (discountAmountSize).sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Yekanbakh,
                    color = Background
                )
                
                Spacer(modifier = modifier.width(2.dp))

                Icon(
                    modifier = modifier.size(8.dp),
                    painter = painterResource(id = R.drawable.percent),
                    contentDescription = null,
                    tint = Background
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewJetDiscount() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        JetDiscount(discountAmount = 35)
    }
}