/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/16/23, 12:06 AM
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
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.designsystem.Primary
import com.example.designsystem.R

@Composable
fun JetCategory(
    imagePath: String? = null,
    title: String,
    onCategoryClick: () -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(120.dp)
        .clickable(enabled = true, onClick = { onCategoryClick() }),
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (imagePath.isNullOrEmpty()) {
                Image(
                    painter = painterResource(id = R.drawable.category_default_image),
                    contentDescription = "category image",
                    contentScale = ContentScale.Crop
                )
            } else {
                JetCoilImage(
                    imageUrl = imagePath
                )
            }
            Column(
                Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Primary.copy(alpha = 0.5f)
                            )
                        )
                    ),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
            ) {
                JetText(
                    text = title,
                    fontSize = 14,
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
    }
}