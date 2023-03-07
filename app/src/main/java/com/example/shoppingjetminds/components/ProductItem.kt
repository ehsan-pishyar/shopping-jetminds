package com.example.shoppingjetminds.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.ui.theme.*

@Composable
fun JetProductItem(
    navController: NavController,
    title: String = "",
    price: Int = 0,
    rating: Double = 0.0,
    sellerTitle: String = ""
) {

    Box {
        Column {

            Card(
                modifier = Modifier
                    .width(200.dp),
                shape = RoundedCornerShape(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Row {
                                Column {
                                    JetText(
                                        modifier = Modifier.padding(end = 3.dp),
                                        text = "4.5",
                                        fontSize = 12
                                    )
                                }
                                Column {
                                    Icon(
                                        modifier = Modifier.width(15.dp),
                                        painter = painterResource(id = R.drawable.star),
                                        contentDescription = null,
                                        tint = YellowColor
                                    )
                                }
                            }
                        }
                    }

                    Column(
                        modifier = Modifier
                            .padding(top = 5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {

                        Image(
                            modifier = Modifier
                                .size(140.dp),
                            painter = painterResource(id = R.drawable.varta_recharge_accu_power_aa_2100mah),
                            contentDescription = null,
                            contentScale = ContentScale.Fit
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        JetText(
                            text = "باتری شارژی قلمی وارتا 2100 میلی آمپر",
                            fontSize = 12,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 2,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Row {
                            JetText(
                                text = "120000",
                                color = Primary,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14
                            )
                            JetText(
                                text = "تومان",
                                color = Primary,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14
                            )
                        }

                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        addProductItemButtons(
                            addToCart = {},
                            addToFavorites = {},
                            addToCompare = {}
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun RowScope.addProductItemButtons(
    addToCart: () -> Unit,
    addToFavorites: () -> Unit,
    addToCompare: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(35.dp)
            .background(LighterGray, shape = RoundedCornerShape(5.dp))
            .clickable { addToCart() },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(15.dp),
                painter = painterResource(id = R.drawable.cart),
                contentDescription = "",
                tint = BlackColor
            )
        }
    }

    Spacer(modifier = Modifier.width(5.dp))

    Box(
        modifier = Modifier
            .size(35.dp)
            .background(LighterGray, shape = RoundedCornerShape(5.dp))
            .clickable { addToFavorites() },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(15.dp),
                painter = painterResource(id = R.drawable.favorite),
                contentDescription = "",
                tint = BlackColor
            )
        }
    }

    Spacer(modifier = Modifier.width(5.dp))

    Box(
        modifier = Modifier
            .size(35.dp)
            .background(LighterGray, shape = RoundedCornerShape(5.dp))
            .clickable { addToCompare() },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(15.dp),
                painter = painterResource(id = R.drawable.compare),
                contentDescription = "",
                tint = BlackColor
            )
        }
    }
}

@Preview
@Composable
fun PreviewJetProductItem1() {
    JetProductItem(navController = NavController(LocalContext.current), title = "باتری شارژی قلمی وارتا 2100 میلی آمپر")
}