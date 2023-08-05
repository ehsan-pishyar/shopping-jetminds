package com.example.shoppingjetminds.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.components.JetHeading
import com.example.shoppingjetminds.components.JetShopProduct
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.components.JetTextField
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.ui.theme.LighterGray
import com.example.shoppingjetminds.uistates.MainShopProductsUiState
import com.example.shoppingjetminds.uistates.ShopProductsUiState
import com.example.shoppingjetminds.viewmodels.ShopViewModel

@Composable
fun ShopScreen(
    viewModel: ShopViewModel = hiltViewModel()
) {
    val uiState: MainShopProductsUiState by viewModel.shopUiState.collectAsState()
    var search by remember { mutableStateOf("") }

    ShopContent(
        uiState = uiState
    )
}

@Composable
private fun ShopContent(
    uiState: MainShopProductsUiState? = null
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
                JetHeading(title = "فروشگاه جت مایندز", hasCartIcon = true)
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ) {
                FilterAndOrderSection()
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ) {
                SearchSection()
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(9f)
            ) {
                ProductsSection(
                    uiState = uiState
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
                    contentDescription = null
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
                    contentDescription = null
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
private fun SearchSection() {
    JetTextField(
        placeholder = "جستجوی محصول ...",
        onValueChange = {},
        height = 50,
        leadingIcon = {
            Icon(
                modifier = Modifier.size(22.dp),
                painter = painterResource(id = R.drawable.search),
                contentDescription = null,
                tint = LighterGray
            )
        }
    )
}

@Composable
private fun ProductsSection(
    uiState: MainShopProductsUiState? = null
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
                    items(count = 10) { position ->
                        JetShopProduct(
                            title = "${state.products[position].name}",
                            image = state.products[position].images?.get(0)?.src,
                            price = state.products[position].price,
                            rating = state.products[position].averageRating,
                            category = state.products[position].categories?.get(0)?.name
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
        ShopContent()
    }
}