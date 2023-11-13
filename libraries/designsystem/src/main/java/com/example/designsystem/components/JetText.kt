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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.designsystem.Background
import com.example.designsystem.BlackColor
import com.example.designsystem.Yekanbakh

@Composable
fun JetText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int = 14,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = BlackColor,
    lineHeight: Double = 1.5,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = Int.MAX_VALUE,
    fontFamily: FontFamily = Yekanbakh,
    fontStyle: FontStyle = FontStyle.Normal,
    overflow: TextOverflow = TextOverflow.Visible,
    softWrap: Boolean = true
) {

    Text(
        modifier = modifier,
        text = text,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        fontSize = (fontSize).sp,
        color = color,
        lineHeight = (lineHeight).em,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        softWrap = softWrap
    )
}

@Preview
@Composable
fun PreviewJetText() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        Column(modifier = Modifier
            .background(Background)
            .height(55.dp),
            verticalArrangement = Arrangement.Center
        ) {
            JetText(
                text = "متن تست",
                fontSize = 20,
                textAlign = TextAlign.Center,
                lineHeight = 0.0,
                maxLines = 1
            )
        }
    }
}