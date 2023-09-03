package com.example.productdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.utils.SharedViewModel
import com.example.core.utils.parseHtml
import com.example.designsystem.Background
import com.example.designsystem.LighterBlack
import com.example.designsystem.LighterGray
import com.example.designsystem.R
import com.example.designsystem.components.AttrsOptions
import com.example.designsystem.components.JetCoilImage
import com.example.designsystem.components.JetHeading
import com.example.designsystem.components.JetPriceText
import com.example.designsystem.components.JetSimpleButton
import com.example.designsystem.components.JetStarText
import com.example.designsystem.components.JetText
import com.example.designsystem.components.LikeButton
import com.example.domain.models.ProductReviewsResponse
import com.example.domain.models.ProductsResponse

@Composable
fun ProductDetailsScreen(
    sharedViewModel: SharedViewModel = SharedViewModel(),
    viewModel: ProductDetailsViewModel = hiltViewModel(),
    toCartScreen: () -> Unit
) {

    // For whole content
    val scrollState = rememberScrollState()
    // Tab states
    val state = remember { mutableIntStateOf(0) }
    // Tab items
    val items = listOf("توضیحات", "ویژگی ها", "نظرات")
    val sharedUiState = sharedViewModel.productState

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
                .weight(5f)
            ) {
                ImageContentSection(
                    image = sharedUiState?.images?.get(0)?.src!!,
                    title = sharedUiState.name!!,
                    price = sharedUiState.price!!,
                    category = sharedUiState.categories?.get(0)?.name!!,
                    onFavoriteBtnClick = {
                        if (sharedUiState.isFavorite == false) {
                            viewModel.updateFavoriteProduct(
                                productId = sharedUiState.id!!,
                                isFavorite = true
                            )
                        } else {
                            viewModel.updateFavoriteProduct(
                                productId = sharedUiState.id!!,
                                isFavorite = false
                            )
                        }
                    },
                    isFavorite = false // todo: fix this shit
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(5f)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                ContentTabsSection(
                    tabs = items,
                    state = state,
                    sharedUiState = sharedUiState!!
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
    image: String = "",
    title: String,
    category: String,
    price: String = "",
    onFavoriteBtnClick: () -> Unit,
    isFavorite: Boolean = false
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
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
            ) { 
            // Feature image
            JetCoilImage(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(shape = RoundedCornerShape(8.dp)),
                imageUrl = image
            )
            }
            
            Spacer(modifier = Modifier.height(10.dp))

            // Title and Category
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(0.7f)
            ) {
                Row(modifier = Modifier
                    .fillMaxSize(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.spacedBy(5.dp)
                ) {
                    // Title
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .weight(2f)
                    ) {
                        JetText(
                            text = title,
                            fontSize = 14,
                            fontWeight = FontWeight.SemiBold,
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 2,
                        )
                    }
                    // Category
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                        verticalArrangement = Arrangement.Top,
                        horizontalAlignment = Alignment.End
                    ) {
                        JetText(
                            text = category,
                            fontSize = 11,
                            fontWeight = FontWeight.Normal,
                            color = LighterGray,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }

            // Price, Like and Rating
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f)
            ) {
                Row(modifier = Modifier
                    .fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Price
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .weight(2f),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        JetPriceText(
                            price = price,
                            priceTextSize = 16,
                            priceTomanSize = 14,
                            priceFreeSize = 16
                        )
                    }
                    // Like and Rating
                    Column(modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            JetStarText()
                            Spacer(modifier = Modifier.width(10.dp))
                            LikeButton(
                                onCLick = { onFavoriteBtnClick() },
                                isFavorite = isFavorite
                            )
                        }
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
    sharedUiState: ProductsResponse
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
                1 -> FeaturesTab(
                    sharedUiState = sharedUiState
                )
                2 -> CommentsTab(
                    sharedUiState = sharedUiState
                )
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
            text = parseHtml(sharedUiState?.description!!),
            fontSize = 13,
            lineHeight = 1.5,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
private fun FeaturesTab(
    sharedUiState: ProductsResponse
) {

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)
    ) {
        AttrsTabContent(
            product = sharedUiState
        )
    }
}

@Composable
private fun CommentsTab(
    sharedUiState: ProductsResponse? = null
) {
    val state = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp)
    ) {
//        when (val reviewsState = reviewsUiState?.reviewsUiState) {
//            com.example.shoppingjetminds.viewmodels.ProductReviewsUiState.Loading -> {
//                Column(modifier = Modifier
//                    .fillMaxSize(),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    JetText(text = "در حال بارگذاری ...")
//                }
//            }
//            is com.example.shoppingjetminds.viewmodels.ProductReviewsUiState.Success -> {
//
//            }
//            is com.example.shoppingjetminds.viewmodels.ProductReviewsUiState.Error -> {
//                Column(modifier = Modifier
//                    .fillMaxSize(),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    JetText(text = reviewsState.message)
//                }
//            }
//            else -> Unit
//        }

        ReviewsNotFound()
    }
}

@Composable
private fun AttrsTabContent(
    product: ProductsResponse
) {
    product.attributes?.let {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            userScrollEnabled = true
        ) {
            items(count = it.size) { position ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .weight(1f)
                    ) {
                        JetText(
                            text = "${product.attributes!![position].name}:",
                            fontSize = 13,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    Column(
                        modifier = Modifier
                            .wrapContentHeight()
                            .weight(2f)
                    ) {
                        AttrsOptions(options = product.attributes!![position].options!!)
                    }
                }
                Spacer(modifier = Modifier.height(5.dp))
                Divider(
                    color = Background
                )
            }
        }
    }
    AttrsNotFound()
}

@Composable
private fun ReviewsTabContent(
    reviews: List<ProductReviewsResponse>
) {
    LazyColumn(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
    ) {

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

@Composable
private fun AttrsNotFound() {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.attrs_404),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        JetText(
            text = "محصول، هیچ ویژگی نداره",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(5.dp))

        JetText(
            text = "این محصولی که در حال مشاهده هستین هیچ ویژگی ای نداره",
            color = LighterBlack,
            fontSize = 12
        )
    }
}

@Composable
private fun ReviewsNotFound() {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.reviews_404),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        JetText(
            text = "هیچ نظری ثبت نشده",
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(5.dp))

        JetText(
            text = "هیچ نظری برای محصول مورد نظر شما ثبت نشده",
            color = LighterBlack,
            fontSize = 12
        )
    }
}