/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/3/23, 12:27 AM
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

package com.example.onboarding

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.designsystem.Background
import com.example.designsystem.LighterBlack
import com.example.designsystem.Primary
import com.example.designsystem.R
import com.example.designsystem.Yekanbakh
import com.example.designsystem.components.JetSimpleButton
import com.example.designsystem.components.JetText
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel = hiltViewModel(),
    toHomeScreen: () -> Unit
){

    val onBoardingItems = listOf(
        OnBoardingItems.First,
        OnBoardingItems.Second,
        OnBoardingItems.Third
    )
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0)

    OnBoardingContent(
        items = onBoardingItems,
        scope = scope,
        pagerState = pagerState,
        toHomeScreen = { toHomeScreen() },
        onBoardingStateCompleted = { viewModel.saveOnBoardingState(completed = true) }
    )
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingContent(
    items: List<OnBoardingItems> = emptyList(),
    scope: CoroutineScope? = null,
    pagerState: PagerState? = null,
    toHomeScreen: () -> Unit,
    onBoardingStateCompleted: () -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
        .padding(15.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(4f)
            ) {
                if (pagerState != null) {
                    ImageSection(onBoardingItems = items, pagerState = pagerState)
                }
            }

            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
            ) {
                if (pagerState != null) {
                    ContentSection(onBoardingItems = items, pagerState = pagerState)
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (pagerState != null) {
                    ButtonSection(pagerState = pagerState) {
                        if (pagerState.currentPage != 2) {
                            scope?.launch {
                                pagerState.scrollToPage(page = pagerState.currentPage + 1)
                            }
                        } else {
                            // Using this method to save OnBoarding state to DataStore
                            onBoardingStateCompleted()
                            toHomeScreen()
                        }
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSection(onBoardingItems: List<OnBoardingItems>, pagerState: PagerState) {
    Card(modifier = Modifier
        .fillMaxSize(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = Primary
        )
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.height(300.dp),
                painter = painterResource(id = onBoardingItems[pagerState.currentPage].image),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(50.dp))

            PagerIndicator(currentPage = pagerState.currentPage, items = onBoardingItems)
        }
    }
}


@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
@Composable
fun ContentSection(onBoardingItems: List<OnBoardingItems>, pagerState: PagerState) {
    HorizontalPager(count = onBoardingItems.size, state = pagerState) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            JetText(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                text = onBoardingItems[pagerState.currentPage].title,
                fontSize = 22,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                lineHeight = 0.0
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                text = onBoardingItems[pagerState.currentPage].description,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                fontFamily = Yekanbakh,
                lineHeight = 2.em,
                color = LighterBlack
            )
        }
    }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun ButtonSection(pagerState: PagerState, onClick: () -> Unit) {
    JetSimpleButton(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth(),
        text =
        if (pagerState.currentPage != 2)
            stringResource(id = R.string.button_next)
        else
            stringResource(id = R.string.button_start)
    )
}

@Composable
fun PagerIndicator(currentPage: Int, items: List<OnBoardingItems>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        repeat(items.size) {
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(isSelected:Boolean){
    val width = animateDpAsState(
        targetValue = if (isSelected) 40.dp else 8.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy), label = ""
    )

    Box(
        modifier = Modifier
            .height(8.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) Background
                else Background.copy(alpha = 0.5f)
            )
    )
}


@OptIn(ExperimentalPagerApi::class)
@Preview
@Composable
fun Preview_OnBoardingScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        OnBoardingContent(
            toHomeScreen = {},
            onBoardingStateCompleted = {}
        )
    }
}