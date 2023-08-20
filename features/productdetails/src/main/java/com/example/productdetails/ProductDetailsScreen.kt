package com.example.productdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.core.utils.SharedViewModel
import com.example.core.utils.priceThousandsSeparator
import com.example.designsystem.Background
import com.example.designsystem.LighterGray
import com.example.designsystem.Primary
import com.example.designsystem.components.JetCoilImage
import com.example.designsystem.components.JetHeading
import com.example.designsystem.components.JetSimpleButton
import com.example.designsystem.components.JetStarText
import com.example.designsystem.components.JetText
import com.example.designsystem.components.LikeButton
import com.example.domain.models.ProductsResponse

@Composable
fun ProductDetailsScreen(
    sharedViewModel: SharedViewModel = SharedViewModel(),
    toCartScreen: () -> Unit
) {

    val scrollState = rememberScrollState()

    val state = remember {
        mutableIntStateOf(0)
    }
    val items = listOf("توضیحات", "ویژگی ها", "نظرات")

    val sharedUiState = sharedViewModel.productState

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
            .verticalScroll(state = scrollState, enabled = true),
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
                ImageContentSection(
                    sharedUiState = sharedUiState
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(4.5f)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                ContentTabsSection(
                    tabs = items,
                    state = state,
                    sharedUiState = sharedUiState
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                verticalArrangement = Arrangement.Bottom
            ) {
                BottomSection(
                    toCartScreen = { toCartScreen() }
                )
            }
        }
    }
}

@Composable
private fun ImageContentSection(
    sharedUiState: ProductsResponse? = null
) {
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
            JetCoilImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp)),
                imageUrl = sharedUiState?.images?.get(0)?.src!!
            )

            Spacer(modifier = Modifier.height(10.dp))

            // Title and category
            Row(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
            ) {
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ) {
                    JetText(
                        text = sharedUiState.name!!,
                        fontSize = 15,
                        fontWeight = FontWeight.SemiBold,
                        overflow = TextOverflow.Clip,
                        maxLines = 2,
                    )
                    JetText(
                        text = priceThousandsSeparator(sharedUiState.price!!),
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
                        text = sharedUiState.categories?.get(0)?.name!!,
                        fontSize = 12,
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
    state: MutableIntState,
    sharedUiState: ProductsResponse? = null
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
                0 -> DescriptionTab(
                    sharedUiState = sharedUiState
                )
                1 -> FeaturesTab()
                2 -> CommentsTab()
            }
        }
    }
}

@Composable
private fun DescriptionTab(
    sharedUiState: ProductsResponse? = null
) {

    val state = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)
        .verticalScroll(state = state, enabled = true)
    ) {
        JetText(
            text = sharedUiState?.description!!,
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
private fun BottomSection(
    toCartScreen: () -> Unit
) {
    JetSimpleButton(
        onClick = { toCartScreen() },
        text = "افزودن به سبد خرید",
        height = 56
    )
}

@Preview
@Composable
fun PreviewProductDetailsScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        ProductDetailsScreen(
            toCartScreen = {}
        )
    }
}