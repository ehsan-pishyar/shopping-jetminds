package com.example.shoppingjetminds.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.ui.theme.Primary

@Composable
fun JetIconText(
    icon: Int? = R.drawable.favorite,
    title: String = "تخفیفات این هفته آنارام"
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = icon!!),
            contentDescription = null,
            tint = Primary
        )

        Spacer(modifier = Modifier.width(5.dp))

        JetText(
            text = title,
            fontSize = 15,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )
    }
}


@Composable
@Preview
fun PreviewJetIconText() {
    JetIconText()
}