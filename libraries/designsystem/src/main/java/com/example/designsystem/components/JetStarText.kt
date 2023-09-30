package com.example.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.designsystem.BlackColor
import com.example.designsystem.R
import com.example.designsystem.YellowColor

@Composable
fun JetStarText(
    rate: Float? = null,
    textSize: Int = 15,
    iconSize: Int = 18
) {
    Row(modifier = Modifier
        .wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        JetText(
            text = "$rate",
            fontSize = textSize,
            color = BlackColor
        )
        Icon(
            modifier = Modifier.size(iconSize.dp),
            painter = painterResource(id = R.drawable.star),
            contentDescription = null,
            tint = YellowColor
        )
    }
}

@Preview
@Composable
private fun Preview_JetStarText() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        JetStarText(
            rate = 4.5f
        )
    }
}