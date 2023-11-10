package com.example.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.designsystem.BlackColor
import com.example.designsystem.LighterGray
import com.example.designsystem.Primary
import com.example.designsystem.R


@Composable
fun CartListItem(
    image: String = "",
    title: String,
    category: String = "",
    price: String = "",
    onProductClick: () -> Unit,
    onDeleteItemClick: () -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(85.dp)
        .clickable(enabled = true, onClick = { onProductClick() }),
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
                .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                JetCoilImage(
                    imageUrl = image,
                    modifier = Modifier.size(75.dp).clip(shape = RoundedCornerShape(8.dp))
                )
            }

            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(2.8f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                JetText(
                    text = title,
                    fontSize = 14,
                    fontWeight = FontWeight.SemiBold,
                    overflow = TextOverflow.Ellipsis
                )
                JetText(
                    text = category,
                    fontSize = 11,
                    fontWeight = FontWeight.Normal,
                    color = LighterGray
                )
                JetPriceText(
                    price = price,
                    priceTextSize = 11,
                    priceTomanSize = 10,
                    priceFreeSize = 11
                )
            }

            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1.2f),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = null,
                    modifier = Modifier
                        .size(15.dp)
                        .clickable(enabled = true, onClick = { onDeleteItemClick() })
                )

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.size(22.dp),
                        shape = RoundedCornerShape(50.dp),
                        contentPadding = PaddingValues(1.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Primary
                        )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.add),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                    }

                    JetText(
                        text = "01",
                        fontSize = 16,
                        fontWeight = FontWeight.SemiBold,
                        color = BlackColor
                    )

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.size(22.dp),
                        shape = RoundedCornerShape(50.dp),
                        contentPadding = PaddingValues(1.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Primary
                        )
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.minus),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Color.White)
                        )
                    }
                }
            }
        }
    }
}