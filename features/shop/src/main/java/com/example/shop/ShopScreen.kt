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

package com.example.shop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.utils.SharedViewModel
import com.example.core.utils.shopProductsSize
import com.example.designsystem.Background
import com.example.designsystem.LighterGray
import com.example.designsystem.R
import com.example.designsystem.components.JetShopHeading
import com.example.designsystem.components.JetShopProduct
import com.example.designsystem.components.JetText

@Composable
fun ShopScreen(
    viewModel: ShopViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = SharedViewModel(),
    toCartScreen: () -> Unit,
    toProductDetailsScreen: () -> Unit,
    toSearchScreen: () -> Unit,
    toNotificationScreen: () -> Unit
) {

    LaunchedEffect(key1 = null) {
        if (sharedViewModel.categoryId > 0) {
            viewModel.getProducts(categoryId = sharedViewModel.categoryId)
        } else {
            viewModel.getProducts()
        }
    }

    val uiState: MainShopProductsUiState by viewModel.shopUiState.collectAsState()
    val cartTotalCountsState by viewModel.cartTotalCountState.collectAsState()

    ShopContent(
        uiState = uiState,
        sharedViewModel = sharedViewModel,
        cartTotalCountsState = cartTotalCountsState,
        toCartScreen = { toCartScreen() },
        toProductDetailsScreen = { toProductDetailsScreen() },
        toSearchScreen = { toSearchScreen() },
        toNotificationScreen = { toNotificationScreen() }
    )
}

@Composable
private fun ShopContent(
    uiState: MainShopProductsUiState? = null,
    sharedViewModel: SharedViewModel? = null,
    cartTotalCountsState: Int = 0,
    toCartScreen: () -> Unit,
    toProductDetailsScreen: () -> Unit,
    toSearchScreen: () -> Unit,
    toNotificationScreen: () -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ) {
                JetShopHeading(
                    toSearchScreen = { toSearchScreen() },
                    toCartScreen = { toCartScreen() },
                    toNotificationScreen = { toNotificationScreen() },
                    cartItemSize = cartTotalCountsState
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                FilterAndOrderSection()
                Divider()
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(10f)
                .padding(top = 10.dp)
            ) {
                ProductsSection(
                    uiState = uiState,
                    sharedViewModel = sharedViewModel,
                    toCartScreen = { toCartScreen() },
                    toProductDetailsScreen = { toProductDetailsScreen() }
                )
            }
        }
    }
}

@Composable
private fun FilterAndOrderSection() {
    // Filters and Order by
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Card(modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    modifier = Modifier.size(22.dp),
                    painter = painterResource(id = R.drawable.filter_icon),
                    contentDescription = null,
                    tint = LighterGray
                )

                Spacer(modifier = Modifier.width(20.dp))

                JetText(
                    text = stringResource(id = R.string.filters)
                )
            }
        }

        Card(modifier = Modifier
            .weight(1f)
            .fillMaxHeight(),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    modifier = Modifier.size(22.dp),
                    painter = painterResource(id = R.drawable.sort_icon),
                    contentDescription = null,
                    tint = LighterGray
                )

                Spacer(modifier = Modifier.width(20.dp))

                JetText(
                    text = stringResource(id = R.string.order_by)
                )
            }
        }
    }
}

@Composable
private fun ProductsSection(
    uiState: MainShopProductsUiState? = null,
    sharedViewModel: SharedViewModel? = null,
    toCartScreen: () -> Unit,
    toProductDetailsScreen: () -> Unit,
    favoritesViewModel: FavoritesViewModel? = null
) {

    when (val state = uiState?.shopProductsUiState) {
        ShopProductsUiState.Loading -> {
            Column(modifier = Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                JetText(text = stringResource(id = R.string.loading))
            }
        }
        is ShopProductsUiState.Success -> {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                userScrollEnabled = true,
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                content = {
                    items(count = shopProductsSize(state.products.size)) { position ->
                        JetShopProduct(
                            title = "${state.products[position].name}",
                            image = state.products[position].images?.get(0)?.src,
                            price = state.products[position].price,
                            rating = state.products[position].averageRating,
                            category = state.products[position].categories?.get(0)?.name,
                            onAddToCartClick = { toCartScreen() },
                            onProductClick = {
                                sharedViewModel?.addProduct(state.products[position])
                                toProductDetailsScreen()
                            },
                            onFavoriteBtnClick = {
                                if (state.products[position].isFavorite == false) {
                                    favoritesViewModel?.updateFavoriteProduct(
                                        productId = state.products[position].id!!,
                                        isFavorite = true
                                    )
                                } else {
                                    favoritesViewModel?.updateFavoriteProduct(
                                        productId = state.products[position].id!!,
                                        isFavorite = false
                                    )
                                }
                            },
                            isFavorite = false
                        )
                    }
                }
            )
        }
        is ShopProductsUiState.Error -> {
            Column(modifier = Modifier
                .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                JetText(text = "${state.throwable.message}")
            }
        }

        else -> {}
    }
}

@Preview
@Composable
private fun PreviewShopScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        ShopContent(
            toCartScreen = {},
            toProductDetailsScreen = {},
            toSearchScreen = {},
            toNotificationScreen = {}
        )
    }
}