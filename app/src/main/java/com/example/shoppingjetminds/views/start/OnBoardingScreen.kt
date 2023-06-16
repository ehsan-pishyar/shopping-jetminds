package com.example.shoppingjetminds.views.start

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.ui.theme.Primary
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.example.shoppingjetminds.components.JetSimpleButton
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.utils.OnBoardingData
import com.example.shoppingjetminds.utils.OnBoardingItems
import com.google.accompanist.pager.HorizontalPager
import kotlinx.coroutines.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    toHomeScreen: () -> Unit
){

    val onBoardingItems = OnBoardingItems.items
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(initialPage = 0)

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
            Card(modifier = Modifier
                .fillMaxWidth()
                .weight(4f),
                shape = RoundedCornerShape(25.dp),
                backgroundColor = Primary
            ) {
                HorizontalPager(count = onBoardingItems.size, state = pagerState) {
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

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(50.dp))

                JetText(
                    modifier = Modifier.fillMaxWidth(),
                    text = onBoardingItems[pagerState.currentPage].title,
                    fontSize = 20,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1,
                    lineHeight = 0.0
                )

                Spacer(modifier = Modifier.height(20.dp))

                JetText(
                    modifier = Modifier.fillMaxWidth(),
                    text = onBoardingItems[pagerState.currentPage].description,
                    fontSize = 14,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    maxLines = 4,
                    lineHeight = 0.0
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                if ((pagerState.currentPage + 1) < onBoardingItems.size) {
                    JetSimpleButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                                  scope.launch {
                                      pagerState.scrollToPage(
                                          pagerState.currentPage + 1,
                                      )
                                  }
                        },
                        text = "بعدی"
                    )
                } else {
                    JetSimpleButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = {
                            toHomeScreen()
                        },
                        text = "ایول، بزن بریم"
                    )
                }
            }
        }
    }
}

@Composable
fun PagerIndicator(currentPage: Int, items: List<OnBoardingData>) {
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
        targetValue = if (isSelected) 40.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy)
    )

    Box(
        modifier = Modifier
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) Background
                else Background.copy(alpha = 0.5f)
            )
    )
}

@Preview
@Composable
fun PreviewOnBoardingScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        OnBoardingScreen {

        }
    }
}