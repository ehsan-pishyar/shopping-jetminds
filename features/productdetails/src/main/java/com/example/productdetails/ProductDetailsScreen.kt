/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/11/23, 12:47 AM
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.utils.SharedViewModel
import com.example.core.utils.getCurrentDate
import com.example.core.utils.parseHtml
import com.example.designsystem.Background
import com.example.designsystem.LighterBlack
import com.example.designsystem.LighterGray
import com.example.designsystem.R
import com.example.designsystem.components.AttrsOptions
import com.example.designsystem.components.JetCoilImage
import com.example.designsystem.components.JetHeading
import com.example.designsystem.components.JetPriceText
import com.example.designsystem.components.JetReview
import com.example.designsystem.components.JetSimpleButton
import com.example.designsystem.components.JetStarText
import com.example.designsystem.components.JetText
import com.example.designsystem.components.LikeButton
import com.example.domain.models.ProductReviewsResponse
import com.example.domain.models.ProductsResponse
import com.example.productdetails.uistate.MainProductDetailsUiState
import com.example.productdetails.uistate.MainProductReviewsUiState
import com.example.productdetails.uistate.ProductDetailsUiState
import com.example.productdetails.uistate.ProductReviewsUiState
import com.example.productdetails.viewmodel.CartViewModel
import com.example.productdetails.viewmodel.FavoritesViewModel
import com.example.productdetails.viewmodel.ProductDetailsViewModel
import com.example.productdetails.viewmodel.ProductReviewsViewModel
import kotlinx.coroutines.launch

@Composable
fun ProductDetailsScreen(
    viewModel: ProductDetailsViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = SharedViewModel(),
    favoritesViewModel: FavoritesViewModel = hiltViewModel(),
    reviewsViewModel: ProductReviewsViewModel = hiltViewModel(),
    cartViewModel: CartViewModel = hiltViewModel(),
    toCartScreen: () -> Unit
) {

    // Tab states
    val state = remember { mutableIntStateOf(0) }

    // Add product id that we get from shared viewModel to viewModel to get stateFlow
    viewModel.addProductId(sharedViewModel.productId)
    val productIdState by viewModel.productIdState.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.getProductDetails(productId = productIdState)
        cartViewModel.isInCartItem(productId = productIdState)
        cartViewModel.getCartItemCount(productId = productIdState)
        reviewsViewModel.getProductReviews(productId = productIdState)
    }

    val productDetailsUiState: MainProductDetailsUiState by viewModel.productDetailsUiState.collectAsState()
    val isInCartUiState by cartViewModel.isInCartUiState.collectAsState()
    val cartItemCountUiState by cartViewModel.cartItemCount.collectAsState()
    val reviewsUiState: MainProductReviewsUiState by reviewsViewModel.reviewsState.collectAsState()
    val cartTotalCountsState by cartViewModel.cartTotalCountState.collectAsState()

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
                    title = stringResource(id = R.string.heading_product_details),
                    hasCartIcon = true,
                    toCartScreen = { toCartScreen() },
                    cartItemSize = cartTotalCountsState
                )
            }
            when (val uiState = productDetailsUiState.productDetailsUiState) {
                ProductDetailsUiState.Loading -> {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(10f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        JetText(text = stringResource(id = R.string.loading))
                    }
                }
                is ProductDetailsUiState.Success -> {
                    println("Product is in cart: $isInCartUiState")
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(5f)
                    ) {
                        ImageContentSection(
                            image = uiState.productDetails.images?.get(0)?.src!!,
                            title = uiState.productDetails.name!!,
                            price = uiState.productDetails.price!!,
                            category = uiState.productDetails.categories?.get(0)?.name!!,
                            rate = uiState.productDetails.averageRating!!,
                            onFavoriteBtnClick = {
                                if (uiState.productDetails.isFavorite == false) {
                                    favoritesViewModel.updateFavoriteProduct(
                                        productId = uiState.productDetails.id!!,
                                        isFavorite = true
                                    )
                                } else {
                                    favoritesViewModel.updateFavoriteProduct(
                                        productId = uiState.productDetails.id!!,
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
                            state = state,
                            sharedUiState = uiState.productDetails,
                            reviewsUiState = reviewsUiState
                        )
                    }
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        BottomSection(
                            cartViewModel = cartViewModel,
                            productId = uiState.productDetails.id!!,
                            title = uiState.productDetails.name!!,
                            image = uiState.productDetails.images?.get(0)?.src!!,
                            category = uiState.productDetails.categories?.get(0)?.name!!,
                            price = uiState.productDetails.price!!,
                            isInCart = isInCartUiState,
                            itemCount = cartItemCountUiState
                        )
                    }
                }
                is ProductDetailsUiState.Error -> {
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(10f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        JetText(text = "${uiState.throwable}")
                    }
                }
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
    isFavorite: Boolean = false,
    rate: String = ""
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
                            JetStarText(
                                rate = rate.toFloat()
                            )
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
    state: MutableIntState,
    sharedUiState: ProductsResponse,
    reviewsUiState: MainProductReviewsUiState? = null
) {

    // Tab items
    val tabs = listOf(
        ProductTabs.DESCRIPTION.tabName,
        ProductTabs.FEATURES.tabName,
        ProductTabs.REVIEWS.tabName
    )

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
            when (state.intValue) {
                0 -> DescriptionTab(
                    sharedUiState = sharedUiState
                )
                1 -> FeaturesTab(
                    sharedUiState = sharedUiState
                )
                2 -> {
                    when (val reviewsState = reviewsUiState?.reviewsUiState) {
                        ProductReviewsUiState.Loading -> {
                            Column(modifier = Modifier
                                .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                JetText(text = stringResource(id = R.string.loading))
                            }
                        }
                        is ProductReviewsUiState.Success -> {
                            CommentsTab(reviews = reviewsState.reviews)
                        }
                        is ProductReviewsUiState.Error -> {
                            Column(modifier = Modifier
                                .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                JetText(text = reviewsState.message)
                            }
                        }
                        else -> Unit
                    }
                }
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
    reviews: List<ProductReviewsResponse> = emptyList()
) {

    if (reviews.isEmpty()) {
        ReviewsNotFound()
    } else {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                userScrollEnabled = true
            ) {
                items(count = reviews.size) { position ->
                    JetReview(
                        avatar = "${reviews[position].avatar?.size96}",
                        reviewer = "${reviews[position].reviewer}",
                        rating = reviews[position].rating!!,
                        review = "${reviews[position].review}",
                        date = "${reviews[position].dateCreated}"
                    )
                }
            }
        }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BottomSection(
    cartViewModel: CartViewModel? = null,
    productId: Int,
    title: String,
    image: String,
    category: String,
    price: String,
    isInCart: Int, // is this product exists in cart table?
    itemCount: Int // how many of this product is in cart table?
) {

    var count by remember { mutableIntStateOf(0) }
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier
            .padding(it)
            .background(Background)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            JetSimpleButton(
                onClick = {
                    count = itemCount
                    if (isInCart == 0) {
                        cartViewModel?.insertCartItem(
                            productId = productId,
                            productTitle = title,
                            productImage = image,
                            productCategory = category,
                            productPrice = price.toInt(),
                            count = (count + 1),
                            dateAdded = getCurrentDate()
                        )
                    } else {
                        cartViewModel?.updateCartItem(
                            productId = productId,
                            productPrice = price.toInt(),
                            count = (count + 1)
                        )
                    }
                    scope.launch {
                        snackbarHostState.showSnackbar("محصول به سبدد خرید اضافه شد.")
                    }
                },
                text = stringResource(id = R.string.button_add_to_cart),
                height = 56
            )
        }
    }
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
            text = stringResource(id = R.string.feature_404_title),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(5.dp))

        JetText(
            text = stringResource(id = R.string.favorites_404_desc),
            color = LighterBlack,
            fontSize = 12
        )
    }
}

@Composable
private fun ReviewsNotFound() {
    Column(
        modifier = Modifier
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
            text = stringResource(id = R.string.comments_404_title),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(5.dp))

        JetText(
            text = stringResource(id = R.string.comments_404_desc),
            color = LighterBlack,
            fontSize = 12
        )
    }
}