package com.example.shoppingjetminds.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.shoppingjetminds.ui.theme.Primary

@Composable
fun JetSimpleButton(
    modifier: Modifier = Modifier,
    height: Int = 66,
    onClick: () -> Unit,
    color: ButtonColors = ButtonDefaults.buttonColors(backgroundColor = Primary),
    shape: Int = 24,
    text: String,
    fontSize: Int = 16,
    fontWeight: FontWeight = FontWeight.Normal,
    textColor: Color = Color.White,
    textAlign: TextAlign = TextAlign.Center
) {

    Button(
        onClick = { onClick() },
        modifier = modifier.fillMaxWidth().height(height.dp),
        colors = color,
        shape = RoundedCornerShape(shape.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 0.dp,
            pressedElevation = 0.dp,
            disabledElevation = 0.dp
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            JetText(
                modifier = Modifier.fillMaxWidth(),
                text = text,
                fontSize = fontSize,
                fontWeight = fontWeight,
                color = textColor,
                textAlign = textAlign,
                maxLines = 1,
                lineHeight = 0.0
            )
        }
    }
}

@Preview
@Composable
fun PreviewJetButton() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        JetSimpleButton(
            onClick = {},
            text = "احسان پیش یار",
            modifier = Modifier.width(364.dp)
        )
    }
}