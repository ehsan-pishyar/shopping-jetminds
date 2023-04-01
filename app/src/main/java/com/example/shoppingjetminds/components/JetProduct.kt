package com.example.shoppingjetminds.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.ui.theme.*

@Composable
fun JetProduct(
    navController: NavController? = null,
    title: String = "باتری شارژی قلمی وارتا 2100 میلی آمپر",
    image: Int? = R.drawable.varta_recharge_accu_power_aa_2100mah,
    price: Int? = 120000,
    rating: Double? = 0.0
) {

    Box {
        Column {

            Card(
                modifier = Modifier
                    .width(180.dp),
                shape = RoundedCornerShape(8.dp)
            ) {

                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    // Rating start
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        JetText(
                            modifier = Modifier.padding(end = 3.dp),
                            text = "$rating",
                            fontSize = 11
                        )
                        Icon(
                            modifier = Modifier.size(13.dp),
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = null,
                            tint = YellowColor
                        )
                    }
                    // Rating end

                    Column(
                        modifier = Modifier
                            .padding(top = 5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {

                        // Feature image
                        Image(
                            modifier = Modifier
                                .size(120.dp),
                            painter = painterResource(id = image!!),
                            contentDescription = null,
                            contentScale = ContentScale.Fit
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        // Title
                        JetText(
                            text = title,
                            fontSize = 11,
                            fontWeight = FontWeight.SemiBold,
                            maxLines = 2,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        // Price start
                        Row {
                            JetText(
                                text = "$price",
                                color = Primary,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12
                            )

                            Spacer(modifier = Modifier.width(5.dp))

                            JetText(
                                text = "تومان",
                                color = Primary,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12
                            )
                        }
                        // Price end

                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Buttons
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
fun JetProduct2(
    navController: NavController? = null,
    title: String = "باتری شارژی قلمی وارتا 2100 میلی آمپر",
    image: Int? = R.drawable.varta_recharge_accu_power_aa_2100mah,
    price: Int? = 120000,
    rating: Double? = 0.0
) {
    Box(modifier = Modifier
        .fillMaxWidth()
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(15.dp)
        ) {
            Image(
                modifier = Modifier.height(100.dp),
                painter = painterResource(id = image!!),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(10.dp))
            
            Column {
                JetText(
                    text = title,
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 2,
                    fontSize = 14
                )
                
                Spacer(modifier = Modifier.height(10.dp))

                // Price start
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    JetText(
                        modifier = Modifier.wrapContentWidth(),
                        text = "$price",
                        color = Primary,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12
                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    JetText(
                        modifier = Modifier.wrapContentWidth(),
                        text = "تومان",
                        color = Primary,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12
                    )
                }
                // Price end

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


@Composable
fun addProductItemButtons(
    addToCart: () -> Unit,
    addToFavorites: () -> Unit,
    addToCompare: () -> Unit
) {
    // Add to cart start
    Box(
        modifier = Modifier
            .size(width = 90.dp, height = 30.dp)
            .background(color = Primary, shape = RoundedCornerShape(5.dp))
            .clickable { addToCart() },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    modifier = Modifier.size(15.dp),
                    painter = painterResource(id = R.drawable.cart),
                    contentDescription = "",
                    tint = Color.White
                )

                Spacer(modifier = Modifier.width(5.dp))

                JetText(
                    text = "افزودن به سبد",
                    fontSize = 9,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Start,
                    color = Color.White
                )
            }

        }
    }
    // Add to cart end

    Spacer(modifier = Modifier.width(5.dp))

    // Favorite start
    Box(
        modifier = Modifier
            .size(30.dp)
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
    // Favorite end

    Spacer(modifier = Modifier.width(5.dp))

    // Compare start
    Box(
        modifier = Modifier
            .size(30.dp)
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
    // Compare end
}

@Preview
@Composable
fun PreviewJetProduct1() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        JetProduct(navController = NavController(LocalContext.current), title = "باتری شارژی قلمی وارتا 2100 میلی آمپر")
    }
}

@Preview
@Composable
fun PreviewJetProduct2() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        JetProduct2()
    }
}