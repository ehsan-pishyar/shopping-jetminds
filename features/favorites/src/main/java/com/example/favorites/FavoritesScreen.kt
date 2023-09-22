package com.example.favorites

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.utils.SharedViewModel
import com.example.designsystem.Background
import com.example.designsystem.LighterBlack
import com.example.designsystem.R
import com.example.designsystem.components.JetCoilImage
import com.example.designsystem.components.JetHeading
import com.example.designsystem.components.JetPriceText
import com.example.designsystem.components.JetText

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = SharedViewModel(),
    toProductDetailsScreen: () -> Unit
){
    val uiState: MainFavoritesUiState by viewModel.state.collectAsState()

    FavoritesContent(
        uiState = uiState,
        sharedViewModel = sharedViewModel,
        toProductDetailsScreen = { toProductDetailsScreen() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun FavoritesContent(
    uiState: MainFavoritesUiState? = null,
    sharedViewModel: SharedViewModel? = null,
    toProductDetailsScreen: () -> Unit
) {
    Scaffold(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) { padding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(padding)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(15.dp)
            ) {
                JetHeading(title = "علاقه مندی ها", hasCartIcon = true)
            }

            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(11f)
                .padding(15.dp)
            ) {
                if (uiState?.favorites?.size == 0) {
                    FavoritesNotFound()
                } else {
                    LazyColumn(
                        userScrollEnabled = true,
                        verticalArrangement = Arrangement.spacedBy(10.dp),
                        contentPadding = PaddingValues(0.dp),
                        content = {
                            items(count = uiState?.favorites?.size!!) { position ->
                                FavoritesItem(
                                    image = uiState.favorites[position].images?.get(0)?.src!!,
                                    title = uiState.favorites[position].name!!,
                                    price = uiState.favorites[position].price!!,
                                    onProductClick = {
                                        sharedViewModel?.addProduct(uiState.favorites[position])
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
}

@Composable
private fun FavoritesItem(
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

@Composable
private fun FavoritesNotFound() {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.favorite),
            contentDescription = null,
            modifier = Modifier.size(100.dp),
            colorFilter = ColorFilter.tint(Color.Black.copy(alpha = 0.2f))
        )

        Spacer(modifier = Modifier.height(20.dp))

        JetText(
            text = "شما هیچ آیتم مورد علاقه ای ندارید",
            fontWeight = FontWeight.Bold
        )

        JetText(
            text = "سعی کنید محصولی را به عنوان مورد علاقه اضافه کنید",
            color = LighterBlack,
            fontSize = 12
        )
    }
}

@Preview
@Composable
private fun Preview_FavoritesScreen() {
    FavoritesContent(
        toProductDetailsScreen = {}
    )
}