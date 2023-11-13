/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/29/23, 9:31 PM
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.designsystem.BlackColor
import com.example.designsystem.R
import com.example.designsystem.YellowColor

@Composable
fun JetStarText(
    rate: Float? = null,
    textSize: Int = 15,
    iconSize: Int = 18
) {
    Row(modifier = Modifier
        .wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        JetText(
            text = "$rate",
            fontSize = textSize,
            color = BlackColor
        )
        Icon(
            modifier = Modifier.size(iconSize.dp),
            painter = painterResource(id = R.drawable.star),
            contentDescription = null,
            tint = YellowColor
        )
    }
}

@Preview
@Composable
private fun Preview_JetStarText() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        JetStarText(
            rate = 4.5f
        )
    }
}