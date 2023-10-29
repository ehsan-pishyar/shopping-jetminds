package com.example.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.utils.priceThousandsSeparator
import com.example.designsystem.Primary

@Composable
fun JetPriceText(
    price: String = "",
    priceTextSize: Int = 14,
    priceTomanSize: Int = 10,
    priceFreeSize: Int = 12,
    color: Color = Primary
) {
    if (price.trim().isEmpty() || price == "0") {
        JetText(
            text = "رایگان",
            color = color,
            fontWeight = FontWeight.SemiBold,
            fontSize = priceFreeSize
        )
    } else {
        Row(modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            JetText(
                text = priceThousandsSeparator(price),
                color = Primary,
                fontWeight = FontWeight.SemiBold,
                fontSize = priceTextSize
            )
            JetText(
                text = "تومان",
                color = color,
                fontWeight = FontWeight.SemiBold,
                fontSize = priceTomanSize
            )
        }
    }
}

@Preview
@Composable
private fun Preview_JetPriceText() {
    JetPriceText(
        price = "",
        priceTextSize = 14,
        priceTomanSize = 10,
        priceFreeSize = 12,
        color = Primary
    )
}