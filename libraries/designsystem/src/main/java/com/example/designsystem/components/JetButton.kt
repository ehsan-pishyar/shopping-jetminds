/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/11/23, 1:28 AM
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

import android.annotation.SuppressLint
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.designsystem.Primary
import com.example.designsystem.R
import kotlinx.coroutines.delay
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow


@Composable
fun JetSimpleButton(
    modifier: Modifier = Modifier,
    width: Int? = null,
    height: Int = 56,
    onClick: () -> Unit,
    color: ButtonColors = ButtonDefaults.buttonColors(containerColor = Primary),
    shape: Int = 10,
    text: String,
    fontSize: Int = 16,
    fontWeight: FontWeight = FontWeight.SemiBold,
    textColor: Color = Color.White,
    textAlign: TextAlign = TextAlign.Center,
    hasLoader: Boolean = false
) {

    Button(
        onClick = { onClick() },
        modifier = if (width == null) {
            modifier
                .fillMaxWidth()
                .height(height.dp)
        } else {
            modifier
                .width(width.dp)
                .height(height.dp)
        },
        colors = color,
        shape = RoundedCornerShape(shape.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        ),
        contentPadding = ButtonDefaults.TextButtonContentPadding
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (hasLoader) {
                LoadingAnimation()
            } else {
                JetText(
                    text = text,
                    fontSize = fontSize,
                    fontWeight = fontWeight,
                    color = textColor,
                    textAlign = textAlign,
                    overflow = TextOverflow.Clip,
                    maxLines = 1,
                    lineHeight = 3.0
                )
            }
        }
    }
}

@Composable
fun JetBtnAddToCart(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(9f),
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { onClick() },
                modifier = modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary),
                shape = RoundedCornerShape(12.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 0.dp,
                    pressedElevation = 0.dp,
                    disabledElevation = 0.dp
                )
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    JetText(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.button_add_to_cart),
                        fontSize = 14,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(3f)
        ) {
            Row(modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = null
                )
                JetText(text = "1")
                Image(
                    painter = painterResource(id = R.drawable.minus),
                    contentDescription = null
                )
            }
        }
    }
}

@SuppressLint("RememberReturnType")
@Composable
fun LoadingAnimation(
    modifier: Modifier = Modifier,
    circleSize: Dp = 10.dp,
    circleColor: Color = Color.White,
    spaceBetween: Dp = 7.dp,
    travelDistance: Dp = 10.dp
) {
    val circles = listOf(
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) },
        remember { Animatable(initialValue = 0f) }
    )

    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(key1 = animatable) {
            delay(index * 100L)
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = 1200
                        0.0f at 0 with LinearOutSlowInEasing
                        1.0f at 300 with LinearOutSlowInEasing
                        0.0f at 600 with LinearOutSlowInEasing
                        0.0f at 1200 with LinearOutSlowInEasing
                    },
                    repeatMode = RepeatMode.Restart
                )
            )
        }
    }

    val circleValues = circles.map { it.value }
    val distance = with(LocalDensity.current) { travelDistance.toPx() }

    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(spaceBetween)
        ) {
            circleValues.forEach { value ->
                Box(
                    modifier = Modifier
                        .size(circleSize)
                        .graphicsLayer {
                            translationY = -value * distance
                        }
                        .background(
                            color = circleColor,
                            shape = CircleShape
                        )
                )
            }
        }
    }
}

@Preview
@Composable
fun Preview_JetSimpleButton() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        JetSimpleButton(
            onClick = {},
            width = 70,
            height = 50,
            text = "ورود",
            fontSize = 11,
            shape = 6,
            hasLoader = false
        )
    }
}

@Preview
@Composable
private fun Preview_JetBtnAddToCart() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        JetBtnAddToCart(
            onClick = {}
        )
    }
}

@Preview
@Composable
private fun Preview_LoadingAnimation() {
    LoadingAnimation(
        modifier = Modifier.fillMaxSize()
    )
}