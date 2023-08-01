package com.example.shoppingjetminds.views.main

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.components.JetHeading
import com.example.shoppingjetminds.components.JetSimpleButton
import com.example.shoppingjetminds.components.JetStarText
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.components.LikeButton
import com.example.shoppingjetminds.ui.theme.LighterGray
import com.example.shoppingjetminds.ui.theme.Primary
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState

@Composable
fun ProductDetailsScreen() {

    val state = remember {
        mutableIntStateOf(0)
    }
    val items = listOf("توضیحات", "ویژگی ها", "نظرات")

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ) {
                JetHeading(
                    title = "محصول تکی",
                    hasCartIcon = true
                    // TODO: Handle toCartScreen Click
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(5.5f)
            ) {
                ImageContentSection()
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(4.5f)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                ContentTabsSection(tabs = items, state = state)
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                verticalArrangement = Arrangement.Bottom
            ) {
                BottomSection()
            }
        }
    }
}

@Composable
private fun ImageContentSection() {
    Card(modifier = Modifier
        .fillMaxSize(),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Feature image
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp)),
                painter = painterResource(id = R.drawable.jetminds_shop_feature_image_example),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Title and category
            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
            ) {
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    JetText(
                        text = "رابط کاربری Masmas – Food Delivery Mobile App UI Kit",
                        fontSize = 15,
                        fontWeight = FontWeight.SemiBold,
                        overflow = TextOverflow.Clip,
                        maxLines = 2,
                    )
                    JetText(
                        text = "49.000 تومان",
                        fontSize = 16,
                        fontWeight = FontWeight.SemiBold,
                        color = Primary
                    )
                }

                // Price, like and rating
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.End
                ) {
                    JetText(
                        text = "رابط کاربری اپلیکیشن",
                        fontSize = 13,
                        fontWeight = FontWeight.Normal,
                        color = LighterGray
                    )
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        JetStarText()
                        Spacer(modifier = Modifier.width(5.dp))
                        LikeButton()
                    }
                }
            }
        }
    }
}

@Composable
private fun ContentTabsSection(
    tabs: List<String>,
    state: MutableIntState
) {

    Card(modifier = Modifier
        .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column {
            TabRow(
                selectedTabIndex = state.intValue
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = state.intValue == index,
                        onClick = { state.intValue = index },
                        text = { JetText(
                            text = title,
                            fontSize = 13,
                            fontWeight = FontWeight.Medium
                        ) }
                    )
                }
            }
//            Text(
//                modifier = Modifier.align(Alignment.CenterHorizontally),
//                text = "Text tab ${state.intValue + 1} selected",
//                style = MaterialTheme.typography.bodyLarge
//            )
            when (state.intValue) {
                0 -> DescriptionTab()
                1 -> FeaturesTab()
                2 -> CommentsTab()
            }
        }
    }
}

@Composable
private fun DescriptionTab() {

    val state = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)
        .verticalScroll(state = state, enabled = true)
    ) {
        JetText(
            text = "لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ، و با استفاده از طراحان گرافیک است، چاپگرها و متون بلکه روزنامه و مجله در ستون و سطرآنچنان که لازم است، و برای شرایط فعلی تکنولوژی مورد نیاز، و کاربردهای متنوع با هدف بهبود ابزارهای کاربردی می باشد، کتابهای زیادی در شصت و سه درصد گذشته حال و آینده، شناخت فراوان جامعه و متخصصان را می طلبد، تا با نرم افزارها شناخت بیشتری را برای طراحان رایانه ای علی الخصوص طراحان خلاقی، و فرهنگ پیشرو در زبان فارسی ایجاد کرد، در این صورت می توان امید داشت که تمام و دشواری موجود در ارائه راهکارها، و شرایط سخت تایپ به پایان رسد و زمان مورد نیاز شامل حروفچینی دستاوردهای اصلی، و جوابگوی سوالات پیوسته اهل دنیای موجود طراحی اساسا مورد استفاده قرار گیرد.",
            fontSize = 13,
            lineHeight = 1.5,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
private fun FeaturesTab() {
    val state = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)
        .verticalScroll(state = state, enabled = true)
    ) {
        JetText(
            text = "ویژگی ها",
            fontSize = 13,
            lineHeight = 1.5,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
private fun CommentsTab() {
    val state = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)
        .verticalScroll(state = state, enabled = true)
    ) {
        JetText(
            text = "نظرات",
            fontSize = 13,
            lineHeight = 1.5,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
private fun BottomSection() {
    JetSimpleButton(
        onClick = { /*TODO*/ },
        text = "افزودن به سبد خرید",
        height = 56
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun CustomIndicator(tabPositions: List<TabPosition>, pagerState: PagerState) {
    val transition = updateTransition(pagerState.currentPage, label = "")
    val indicatorStart by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 50f)
            } else {
                spring(dampingRatio = 1f, stiffness = 1000f)
            }
        }, label = ""
    ) {
        tabPositions[it].left
    }

    val indicatorEnd by transition.animateDp(
        transitionSpec = {
            if (initialState < targetState) {
                spring(dampingRatio = 1f, stiffness = 1000f)
            } else {
                spring(dampingRatio = 1f, stiffness = 50f)
            }
        }, label = ""
    ) {
        tabPositions[it].right
    }

    Box(
        Modifier
            .offset(x = indicatorStart)
            .wrapContentSize(align = Alignment.BottomStart)
            .width(indicatorEnd - indicatorStart)
            .padding(2.dp)
            .fillMaxSize()
            .background(color = Color(0xFFFF7455), RoundedCornerShape(50))
            .border(BorderStroke(2.dp, Color(0xFFC13D25)), RoundedCornerShape(50))
            .zIndex(1f)
    )
}

@Preview
@Composable
fun PreviewProductDetailsScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        ProductDetailsScreen()
    }
}