/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/30/23, 11:49 PM
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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.core.utils.parseHtml
import com.example.designsystem.LighterGray

@Composable
fun JetReview(
    avatar: String = "",
    reviewer: String = "",
    rating: Int? = null,
    review: String = "",
    date: String = ""
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .background(Color.White)
    ) {
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JetCoilImage(
                imageUrl = avatar,
                modifier = Modifier
                    .size(40.dp)
                    .clip(shape = RoundedCornerShape(100.dp))
            )
        }

        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(5f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                JetText(
                    text = reviewer,
                    fontSize = 12,
                    fontWeight = FontWeight.SemiBold
                )
                if (rating != 0) {
                    JetStarText(
                        rate = rating?.toFloat(),
                        textSize = 12,
                        iconSize = 13
                    )
                }
            }
            JetText(
                text = parseHtml(review),
                fontSize = 11,
                fontWeight = FontWeight.Normal,
                color = LighterGray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            SectionSpacer(5)
            JetText(
                text = date,
                fontSize = 11,
                fontWeight = FontWeight.Normal,
                color = LighterGray
            )
        }
    }
}

@Preview
@Composable
private fun Preview_JetReview() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        JetReview(
            avatar = "",
            reviewer = "احسان پیش یار",
            rating = 4,
            review = "یکی از بهترین محصولاتی بود که خریداری کردم. دستتون درد نکنه واقعا خسته نباشید.",
            date = "21/04/1402"
        )
    }
}