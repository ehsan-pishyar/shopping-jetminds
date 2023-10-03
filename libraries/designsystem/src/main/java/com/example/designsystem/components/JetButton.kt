package com.example.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.designsystem.Primary
import com.example.designsystem.R


@Composable
fun JetSimpleButton(
    modifier: Modifier = Modifier,
    height: Int = 56,
    onClick: () -> Unit,
    color: ButtonColors = ButtonDefaults.buttonColors(containerColor = Primary),
    shape: Int = 10,
    text: String,
    fontSize: Int = 16,
    fontWeight: FontWeight = FontWeight.SemiBold,
    textColor: Color = Color.White,
    textAlign: TextAlign = TextAlign.Center
) {

    Button(
        onClick = { onClick() },
        modifier = modifier
            .fillMaxWidth()
            .height(height.dp),
        colors = color,
        shape = RoundedCornerShape(shape.dp),
        elevation = ButtonDefaults.buttonElevation(
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
                textAlign = textAlign
            )
        }
    }
}

@Composable
fun JetBtnAddToCart(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(56.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(9f),
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { onClick() },
                modifier = modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary),
                shape = RoundedCornerShape(12.dp),
                elevation = ButtonDefaults.buttonElevation(
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
                        text = stringResource(id = R.string.button_add_to_cart),
                        fontSize = 14,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
        Column(modifier = Modifier
            .fillMaxHeight()
            .weight(3f)
        ) {
            Row(modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = null
                )
                JetText(text = "1")
                Image(
                    painter = painterResource(id = R.drawable.minus),
                    contentDescription = null
                )
            }
        }
    }
}

@Preview
@Composable
fun Preview_JetButton() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        JetSimpleButton(
            onClick = {},
            text = "احسان پیش یار",
            modifier = Modifier.width(364.dp)
        )
    }
}

@Preview
@Composable
private fun Preview_JetBtnAddToCart() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        JetBtnAddToCart(
            onClick = {}
        )
    }
}