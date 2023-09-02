package com.example.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.utils.SharedViewModel
import com.example.core.utils.calculateTax
import com.example.designsystem.Background
import com.example.designsystem.LighterBlack
import com.example.designsystem.LighterGray
import com.example.designsystem.Primary
import com.example.designsystem.R
import com.example.designsystem.components.CartListItem
import com.example.designsystem.components.JetHeading
import com.example.designsystem.components.JetSimpleButton
import com.example.designsystem.components.JetText
import com.example.designsystem.components.JetTextField
import com.example.domain.models.ProductsResponse

@Composable
fun CartScreen(
    viewModel: CartViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel
) {
    val uiState: MainCartUiState by viewModel.cartUiState.collectAsState()

    CartContent(uiState = uiState)
}

@Composable
private fun CartContent(
    uiState: MainCartUiState? = null
) {
    var totalPrice = remember { "" }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ) {
                JetHeading(
                    title = "سبد خرید",
                    hasCartIcon = true
                    // TODO: Handle toCartScreen Click
                )
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(6f),
                verticalArrangement = Arrangement.Top
            ) {
                when (val state = uiState?.cartUiState) {
                    CartUiState.Loading -> {
                        Column(modifier = Modifier
                            .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            JetText(text = "در حال بارگذاری ...")
                        }
                    }
                    is CartUiState.Success -> {
                        if (state.items.isEmpty()) {
                            CartItemNotFound()
                        } else {
                            CartList(items = state.items)
                            state.items.forEach {
                                totalPrice += it.price!!
                            }
                        }
                    }
                    is CartUiState.Error -> {
                        Column(modifier = Modifier
                            .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            JetText(text ="${state?.throwable}")
                        }
                    }
                    else -> Unit
                }
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ) {
                PromoSection()
            }
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(4f)
            ) {
                CheckoutSection()
            }
        }
    }
}

@Composable
fun CartList(items: List<ProductsResponse>) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(15.dp),
        content = {
        items(count = items.size) { position ->
            CartListItem(
                image = "${items[position].images?.get(0)?.src}",
                title = "${items[position].name}",
                category = "${items[position].categories?.get(0)?.name}",
                price = "${items[position].price}"
            )
        }
    })
}

@Composable
fun PromoSection() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalAlignment = Alignment.Bottom
    ) {
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(3.8f),
            verticalArrangement = Arrangement.Bottom
        ) {
            JetTextField(
                placeholder = "کد تخفیف",
                onValueChange = {},
                height = 56,
                shape = 12,
                singleLine = true,
                modifier = Modifier.wrapContentWidth()
            )
        }

        // Promo button
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(1.2f),
            verticalArrangement = Arrangement.Bottom
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Primary
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                JetText(
                    text = "اعمال کد",
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun CheckoutSection(totalPrice: String = "") {
    var taxAmount = remember { "" }

    Card(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    JetText(
                        text = "جمع جزء",
                        fontSize = 16,
                        fontWeight = FontWeight.Bold
                    )
                    JetText(
                        text = totalPrice,
                        fontSize = 15,
                        fontWeight = FontWeight.Normal
                    )
                }

                Divider()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    JetText(
                        text = "مالیات",
                        fontSize = 16,
                        fontWeight = FontWeight.Bold
                    )
                    JetText(
                        text = calculateTax(totalPrice),
                        fontSize = 15,
                        fontWeight = FontWeight.Normal
                    )
                }

                Divider()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    JetText(
                        text = "جمع کل",
                        fontSize = 16,
                        fontWeight = FontWeight.Bold
                    )
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        JetText(
                            text = "(3 آیتم)",
                            fontSize = 12,
                            fontWeight = FontWeight.Normal,
                            color = LighterGray
                        )
                        JetText(
                            text = "",
                            fontSize = 15,
                            fontWeight = FontWeight.Normal
                        )
                    }
                }
            }

            Column {
                JetSimpleButton(
                    onClick = { /*TODO*/ },
                    text = "ادامه جهت تسویه حساب"
                )
            }
        }
    }
}

@Composable
private fun CartItemNotFound() {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.cart_404),
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        JetText(
            text = "سبد خرید شما خالیه",
            fontWeight = FontWeight.Bold
        )

        JetText(
            text = "در حال حاضر هیچ محصولی توی سبد خرید شما نیستش",
            color = LighterBlack,
            fontSize = 12
        )
    }
}

@Preview
@Composable
fun Preview_CartScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        CartContent()
    }
}