package com.example.shoppingjetminds.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingjetminds.ui.theme.Primary
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.ui.theme.LighterBlack

@Composable
fun JetProductItem(
    navController: NavController,
    title: String = "",
    price: Int = 0,
    rating: Double = 0.0,
    sellerTitle: String = ""
) {

    Box {
        CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {

            Column {

                Card(
                    modifier = Modifier
                        .width(200.dp),
                    shape = RoundedCornerShape(15.dp),
                    border = BorderStroke(width = 2.dp, color = Primary)
                ) {

                    Column(
                        modifier = Modifier.padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {

                            Column(
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    modifier = Modifier.width(25.dp),
                                    painter = painterResource(id = R.drawable.share_default),
                                    contentDescription = null,
                                    tint = Primary
                                )
                            }

                            Column(
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.End,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    modifier = Modifier.width(25.dp),
                                    painter = painterResource(id = R.drawable.heart_default_empty),
                                    contentDescription = null,
                                    tint = Primary
                                )
                            }
                        }

                        Image(
                            modifier = Modifier
                                .size(100.dp),
                            painter = painterResource(id = R.drawable.varta_recharge_accu_power_aa_2100mah),
                            contentDescription = null,
                            contentScale = ContentScale.Fit
                        )

                        JetText(
                            modifier = Modifier.padding(PaddingValues(top = 10.dp)),
                            text = "پیتزا پپرونی با قارچ",
                            fontSize = 14,
                            fontWeight = FontWeight.Bold
                        )

                        JetText(
                            modifier = Modifier.padding(PaddingValues(top = 5.dp)),
                            text = "(فست فود امیر)",
                            fontSize = 11,
                            fontWeight = FontWeight.Normal,
                            color = LighterBlack
                        )

                        Row(modifier = Modifier.padding(PaddingValues(top = 10.dp))) {
                            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.Start) {
                                JetText(
                                    text = "120000 ت",
                                    color = Primary,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize = 14
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .weight(1f),
                                horizontalAlignment = Alignment.End,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ){
                                    Box(
                                        contentAlignment = Alignment.Center
                                    ) {

                                    }

                                    Spacer(modifier = Modifier.width(5.dp))

                                    Icon(
                                        modifier = Modifier
                                            .size(15.dp),
                                        painter = painterResource(id = R.drawable.star_default),
                                        contentDescription = null,
                                        tint = Color.Yellow
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewJetProductItem1() {
    JetProductItem(navController = NavController(LocalContext.current), title = "باتری شارژی قلمی وارتا 2100 میلی آمپر")
}