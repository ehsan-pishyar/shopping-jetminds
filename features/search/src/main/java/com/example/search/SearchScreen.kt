/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/10/23, 10:48 PM
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

package com.example.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.utils.SharedViewModel
import com.example.designsystem.Background
import com.example.designsystem.components.JetCoilImage
import com.example.designsystem.components.JetPriceText
import com.example.designsystem.components.JetText
import com.example.designsystem.components.JetTextField
import com.example.designsystem.components.SectionSpacer
import com.example.domain.models.ProductsResponse

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = SharedViewModel(),
    toProductDetailsScreen: () -> Unit
) {
    val productsUiState: MainProductsUiState by viewModel.productsUiState.collectAsState()
    val searchText by viewModel.searchText.collectAsState()
    val isSearching by viewModel.isSearching.collectAsState()
    val products by viewModel.products.collectAsState()

    when (val productsState = productsUiState.response) {
        ProductsUiState.Loading -> {}
        is ProductsUiState.Success -> {
            viewModel.addProducts(products = productsState.products)
        }
        is ProductsUiState.Error -> {}
    }

    SearchContent(
        sharedViewModel = sharedViewModel,
        searchText = searchText,
        isSearching = isSearching,
        products = products,
        viewModel = viewModel,
        toProductDetailsScreen = toProductDetailsScreen
    )
}

@Composable
private fun SearchContent(
    sharedViewModel: SharedViewModel? = null,
    searchText: String = "",
    isSearching: Boolean = false,
    products: List<ProductsResponse> = emptyList(),
    viewModel: SearchViewModel,
    toProductDetailsScreen: () -> Unit
) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ) {
            JetTextField(
                placeholder = "اسم محصول رو وارد کن ...",
                onValueChange = viewModel::onSearchTextChanged,
                value = searchText
            )
            SectionSpacer()
            if (isSearching) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            } else {
                LazyColumn(
                    userScrollEnabled = true,
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    content = {
                        items(count = products.size) { position ->
                            ListItems(
                                image = products[position].images?.get(0)?.src!!,
                                title = products[position].name!!,
                                price = products[position].price!!,
                                onProductClick = {
                                    sharedViewModel?.addProduct(products[position])
                                    toProductDetailsScreen()
                                }
                            )
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ListItems(
    image: String = "",
    title: String,
    price: String = "",
    onProductClick: () -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(90.dp)
        .clickable { onProductClick() },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1.2f),
                verticalArrangement = Arrangement.Center
            ) {
                JetCoilImage(
                    imageUrl = image,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(shape = RoundedCornerShape(8.dp))
                )
            }

            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(2.7f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                JetText(
                    text = title,
                    fontSize = 12,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                JetPriceText(
                    price = price,
                    priceTextSize = 11,
                    priceTomanSize = 10,
                    priceFreeSize = 11
                )
            }
        }
    }
}