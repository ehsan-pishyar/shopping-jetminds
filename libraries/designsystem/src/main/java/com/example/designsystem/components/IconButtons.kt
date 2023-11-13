/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/9/23, 2:25 PM
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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.Primary
import com.example.designsystem.RedColor

@Composable
fun LikeButton(
    onCLick: () -> Unit,
    isFavorite: Boolean = false
) {
    Box {
        Button(modifier = Modifier
            .size(25.dp),
            contentPadding = PaddingValues(5.dp),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isFavorite) RedColor else Primary
            ),
            onClick = { onCLick() }
        ) {
            Image(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                colorFilter = ColorFilter.tint(color = Color.White)
            )
        }
    }
}

@Composable
fun BuyButton(
    onCLick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Int = 8
) {
    Button(modifier = modifier,
        contentPadding = PaddingValues(5.dp),
        shape = RoundedCornerShape(shape.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Primary),
        onClick = { onCLick() }
    ) {
        Image(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint(color = Color.White)
        )
    }
}

@Preview
@Composable
fun Preview_LikeButton() {
    LikeButton(
        onCLick = {},
        isFavorite = false
    )
}

@Preview
@Composable
fun Preview_BuyButton() {
    BuyButton(
        onCLick = {}
    )
}