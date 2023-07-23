package com.example.shoppingjetminds.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.ui.theme.BlackColor
import com.example.shoppingjetminds.ui.theme.Yekanbakh

@Composable
fun JetText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int = 14,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = BlackColor,
    lineHeight: Double = 1.0,
    textAlign: TextAlign = TextAlign.Start,
    maxLines: Int = 1,
    fontFamily: FontFamily = Yekanbakh,
    fontStyle: FontStyle = FontStyle.Normal,
    overflow: TextOverflow = TextOverflow.Visible
) {

    Text(
        modifier = modifier,
        text = text,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        fontSize = (fontSize).sp,
        color = color,
        lineHeight = (lineHeight).em,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Preview
@Composable
fun PreviewJetText() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        Column(modifier = Modifier
            .background(Background)
            .height(55.dp),
            verticalArrangement = Arrangement.Center
        ) {
            JetText(
                text = "متن تست",
                fontSize = 20,
                textAlign = TextAlign.Center,
                lineHeight = 0.0,
                maxLines = 1
            )
        }
    }
}