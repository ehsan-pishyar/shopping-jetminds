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
    favoritesViewModel: FavoritesViewModel = hiltViewModel(),
    toCartScreen: () -> Unit,
    toProductDetailsScreen: () -> Unit
) {

    LaunchedEffect(key1 = null) {
        if (sharedViewModel.categoryId > 0) {
            viewModel.getProducts(categoryId = sharedViewModel.categoryId)
        } else {
            viewModel.getProducts()
        }
    }

    val uiState: MainShopProductsUiState by viewModel.shopUiState.collectAsState()
    var search by remember { mutableStateOf("") }

    ShopContent(
        uiState = uiState,
        sharedViewModel = sharedViewModel,
        toCartScreen = { toCartScreen() },
        toProductDetailsScreen = { toProductDetailsScreen() },
        favoritesViewModel = favoritesViewModel
    )
}

@Composable
private fun ShopContent(
    uiState: MainShopProductsUiState? = null,
    sharedViewModel: SharedViewModel? = null,
    toCartScreen: () -> Unit,
    toProductDetailsScreen: () -> Unit,
    favoritesViewModel: FavoritesViewModel? = null
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
                    toSearchScreen = {  },
                    toCartScreen = {  },
                    toNotificationScreen = {  }
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
                    text = "فیلتر ها"
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
                    text = "مرتب سازی"
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
                JetText(text = "در حال بارگذاری ...")
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
            toProductDetailsScreen = {}
        )
    }
}