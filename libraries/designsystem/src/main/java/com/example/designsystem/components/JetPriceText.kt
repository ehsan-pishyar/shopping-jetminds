package com.example.designsystem.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.example.core.utils.priceThousandsSeparator
import com.example.designsystem.Primary

@Composable
fun JetPriceText(price: String?) {
    if (price?.trim()?.isNotEmpty() == true) {
        JetText(
            text = priceThousandsSeparator(price),
            color = Primary,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14
        )

        JetText(
            text = "تومان",
            color = Primary,
            fontWeight = FontWeight.SemiBold,
            fontSize = 10
        )
    } else {
        JetText(
            text = "رایگان",
            color = Primary,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12
        )
    }
}