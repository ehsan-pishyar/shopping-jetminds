/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 8/27/23, 11:08 PM
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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.designsystem.Primary

@Composable
fun AttrsOptions(options: List<String>) {
    LazyRow(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
        .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        userScrollEnabled = true
    ) {
        items(count = options.size) { position ->
            OptionsItem(item = options[position])
        }
    }
}

@Composable
fun OptionsItem(item: String) {
    Card(modifier = Modifier
        .wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = Primary.copy(alpha = 0.2f)
        ),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        )
    ) {
        Column(modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 3.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JetText(
                text = item,
                fontSize = 11
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview_OptionsItem() {
    OptionsItem(item = "احسان")
}

@Preview(showBackground = true)
@Composable
private fun Preview_AttrsOptions() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        AttrsOptions(options = listOf("احسان", "فاطمه", "قلبک", "احسانک"))
    }
}