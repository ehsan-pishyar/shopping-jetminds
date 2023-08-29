package com.example.designsystem.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.example.core.utils.priceThousandsSeparator
import com.example.designsystem.Primary

@Composable
fun JetPriceText(
    price: String = "",
    priceTextSize: Int = 14,
    priceTomanSize: Int = 10,
    priceFreeSize: Int = 12
) {
    if (price.trim().isEmpty()) {
        JetText(
            text = priceThousandsSeparator(price),
            color = Primary,
            fontWeight = FontWeight.SemiBold,
            fontSize = priceTextSize
        )

        JetText(
            text = "تومان",
            color = Primary,
            fontWeight = FontWeight.SemiBold,
            fontSize = priceTomanSize
        )
    } else {
        JetText(
            text = "رایگان",
            color = Primary,
            fontWeight = FontWeight.SemiBold,
            fontSize = priceFreeSize
        )
    }
}