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
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.ui.theme.*

@Composable
fun JetProduct(
    title: String = "باتری شارژی قلمی وارتا 2100 میلی آمپر",
    image: Int? = R.drawable.varta_recharge_accu_power_aa_2100mah,
    price: Int? = 120000,
    rating: Double? = 4.5
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
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ) {
                            JetIconText(
                                icon = R.drawable.star,
                                iconSize = 14,
                                title = "$rating",
                                titleSize = 10,
                            )
                        }
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
                            textAlign = TextAlign.Center,
                            lineHeight = 1.5
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        // Price start
                        Row(verticalAlignment = Alignment.CenterVertically) {
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
                                fontSize = 10
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
    title: String = "باتری شارژی قلمی وارتا 2100 میلی آمپر دو تایی",
    image: Int? = R.drawable.varta_recharge_accu_power_aa_2100mah,
    price: Int? = 120000,
    rating: Double? = 4.5
) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .background(Color.Transparent),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            shape = RoundedCornerShape(8.dp)
        ) {
            Row(modifier = Modifier.padding(15.dp)) {
                Image(
                    modifier = Modifier.height(130.dp),
                    painter = painterResource(id = image!!),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr ) {
                        JetIconText(
                            icon = R.drawable.star,
                            iconSize = 14,
                            title = "$rating",
                            titleSize = 10,
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    JetText(
                        text = title,
                        textAlign = TextAlign.Start,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 2,
                        fontSize = 14,
                        lineHeight = 1.5
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
                            fontSize = 14
                        )

                        Spacer(modifier = Modifier.width(5.dp))

                        JetText(
                            modifier = Modifier.wrapContentWidth(),
                            text = "تومان",
                            color = Primary,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12,
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
}

@Composable
fun JetOnSaleProduct(
    title: String = "باتری شارژی قلمی وارتا 2100 میلی آمپر",
    image: Int? = R.drawable.varta_recharge_accu_power_aa_2100mah,
    regularPrice: Int? = 120000,
    salePrice: Int? = 99000,
    rating: Double? = 4.5
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
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentHeight(),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ) {
                            JetIconText(
                                icon = R.drawable.star,
                                iconSize = 14,
                                title = "$rating",
                                titleSize = 10,
                            )
                        }
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentHeight(),
                            horizontalAlignment = Alignment.End
                        ) {
                            JetDiscount(
                                discountAmount = 35
                            )
                        }
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
                                .size(100.dp),
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
                            textAlign = TextAlign.Center,
                            lineHeight = 1.5
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        // Price start
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            // Regular Price
                            Row(
                                modifier = Modifier.weight(1f),
                                horizontalArrangement = Arrangement.Start,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                JetText(
                                    text = "$regularPrice",
                                    color = LighterBlack,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 10,
                                    maxLines = 1,
                                    lineHeight = 1.0
                                )

                                Spacer(modifier = Modifier.width(5.dp))

                                JetText(
                                    text = "تومان",
                                    color = LighterBlack,
                                    fontWeight = FontWeight.Normal,
                                    fontSize = 8,
                                    maxLines = 1,
                                    lineHeight = 1.0
                                )
                            }
                            // Featured Price
                            Row(
                                modifier = Modifier.weight(1f),
                                horizontalArrangement = Arrangement.End,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                JetText(
                                    text = "$salePrice",
                                    color = Primary,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 12,
                                    maxLines = 1,
                                    lineHeight = 1.0
                                )

                                Spacer(modifier = Modifier.width(5.dp))

                                JetText(
                                    text = "تومان",
                                    color = Primary,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 10,
                                    maxLines = 1,
                                    lineHeight = 1.0
                                )
                            }
                        }
                        // Price end
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Buttons
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        addProductItemButtons(
                            addToCart = {},
                            addToFavorites = {},
                            addToCompare = {}
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    // Countdown
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        addOnSaleProductTimers(
                            days = 258,
                            hours = 11,
                            minutes = 57,
                            seconds = 31
                        )
                    }
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
                    color = Color.White,
                    maxLines = 1,
                    lineHeight = 0.0
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

@Composable
fun addOnSaleProductTimers(
    days: Int? = null,
    hours: Int? = null,
    minutes: Int? = null,
    seconds: Int? = null
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Seconds
        Column(modifier = Modifier
            .weight(1f)
            .height(30.dp)
            .fillMaxSize()
            .background(color = LighterGray, shape = RoundedCornerShape(3.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            JetText(
                text = "$seconds",
                fontSize = 10,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                color = RedColor
            )
            JetText(
                text = "ثانیه",
                fontSize = 6,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center
            )

        }
        // Minutes
        Column(modifier = Modifier
            .weight(1f)
            .height(30.dp)
            .fillMaxSize()
            .background(color = LighterGray, shape = RoundedCornerShape(3.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            JetText(
                text = "$minutes",
                fontSize = 10,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                color = RedColor
            )
            JetText(
                text = "دقیقه",
                fontSize = 6,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center
            )
        }
        // Hours
        Column(modifier = Modifier
            .weight(1f)
            .height(30.dp)
            .fillMaxSize()
            .background(color = LighterGray, shape = RoundedCornerShape(3.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            JetText(
                text = "$hours",
                fontSize = 10,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                color = RedColor
            )
            JetText(
                text = "ساعت",
                fontSize = 6,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center
            )
        }
        // Days
        Column(modifier = Modifier
            .weight(1f)
            .height(30.dp)
            .fillMaxSize()
            .background(color = LighterGray, shape = RoundedCornerShape(3.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            JetText(
                text = "$days",
                fontSize = 10,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                color = RedColor
            )
            JetText(
                text = "روز",
                fontSize = 6,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center
            )
        }
    }
}


@Preview
@Composable
fun PreviewJetProduct1() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        //JetProduct()
    }
}

@Preview
@Composable
fun PreviewJetProduct2() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        JetProduct2()
    }
}

@Preview
@Composable
fun PreviewJetOnSaleProduct() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        //JetOnSaleProduct()
    }
}