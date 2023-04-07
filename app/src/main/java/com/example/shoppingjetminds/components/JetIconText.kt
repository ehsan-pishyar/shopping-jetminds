package com.example.shoppingjetminds.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.ui.theme.BlackColor
import com.example.shoppingjetminds.ui.theme.YellowColor

@Composable
fun JetIconText(
    modifier: Modifier = Modifier,
    icon: Int = R.drawable.star,
    title: String = "تخفیفات این هفته آنارام",
    iconSize: Int = 15,
    iconColor: Color = YellowColor,
    titleSize: Int = 12,
    titleColor: Color = BlackColor
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = modifier.size(iconSize.dp),
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = iconColor
        )

        Spacer(modifier = modifier.width(2.dp))

        JetText(
            text = title,
            fontSize = titleSize,
            lineHeight = 1.0,
            color = titleColor
        )
    }
}


@Composable
@Preview
fun PreviewJetIconText() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        Row(
            modifier = Modifier
                .background(Background)
                .height(50.dp)
                .width(100.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            JetIconText(
                icon = R.drawable.star,
                title = "4.5",
                iconSize = 15,
                iconColor = YellowColor,
                titleSize = 11
            )
        }
    }
}