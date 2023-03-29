package com.example.shoppingjetminds.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.ui.theme.Primary

@Composable
fun JetButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    width: Int? = null,
    height: Int? = null,
    color: ButtonColors = ButtonDefaults.buttonColors(backgroundColor = Primary),
    shape: Int = 12,
    text: String? = null,
    icon: Int? = null,
    fontSize: Int = 16,
    fontWeight: FontWeight = FontWeight.Normal,
    iconSize: Int? = null,
    iconColor: Color = Primary,
    textColor: Color = Color.White,
    textAlign: TextAlign = TextAlign.Center
) {

    val iconButtonSize = iconSize!! + 5

    Button(
        onClick = { onClick() },
        modifier = if ((width != null && width > 0) && (height != null && height > 0)) {
            modifier
                .width(width.dp)
                .height(height.dp)
        } else if (text.isNullOrEmpty()) {
            Modifier
                .size(iconButtonSize.dp)
        } else {
            modifier
                .fillMaxWidth()
                .height(height!!.dp)
        },
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
            if (icon != null) {
                Icon(
                    modifier = Modifier.size(iconSize.dp),
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = iconColor
                )
            }

            Spacer(modifier = Modifier.width(5.dp))

            if (!text.isNullOrEmpty()) {
                JetText(
                    modifier = Modifier.wrapContentWidth(),
                    text = text,
                    fontSize = fontSize,
                    fontWeight = fontWeight,
                    color = textColor,
                    textAlign = textAlign
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewJetButton() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        JetButton(
            onClick = {},
            color = ButtonDefaults.buttonColors(backgroundColor = Background),
            shape = 8,
            icon = R.drawable.cart,
            fontSize = 14,
            iconSize = 35,
            iconColor = Primary,
            fontWeight = FontWeight.Normal,
            textColor = Primary,
            textAlign = TextAlign.Start
        )
    }
}