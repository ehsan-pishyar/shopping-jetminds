package com.example.shoppingjetminds.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.example.shoppingjetminds.ui.theme.BlackColor
import com.example.shoppingjetminds.ui.theme.Yekanbakh

@Composable
fun JetText(
    modifier: Modifier = Modifier,
    text: String = "",
    fontSize: Int = 14,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = BlackColor,
    lineHeight: TextUnit = 1.8.em,
    textAlign: TextAlign = TextAlign.Justify,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Visible,
    fontFamily: FontFamily = Yekanbakh,
    fontStyle: FontStyle = FontStyle.Normal
) {

    Text(
        modifier = modifier,
        text = text,
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontStyle = fontStyle,
        fontSize = (fontSize).sp,
        color = color,
        lineHeight = lineHeight,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow
    )
}

@Preview
@Composable
fun PreviewJetText() {
    JetText(
        text = "متن تست",
        fontSize = 20,
        textAlign = TextAlign.Center
    )
}