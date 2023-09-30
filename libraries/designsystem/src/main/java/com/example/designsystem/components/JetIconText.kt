package com.example.designsystem.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.designsystem.BlackColor
import com.example.designsystem.Primary
import com.example.designsystem.R

@Composable
fun JetIconText(
    toShopScreen: () -> Unit
) {
    Button(
        modifier = Modifier.width(80.dp).height(25.dp),
        onClick = { toShopScreen() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(4.dp),
        contentPadding = PaddingValues(2.dp)
    ) {
        JetText(
            text = "مشاهده همه",
            fontSize = 10,
            color = BlackColor
        )

        Spacer(modifier = Modifier.width(2.dp))

        Icon(
            modifier = Modifier.size(12.dp),
            painter = painterResource(id = R.drawable.play),
            contentDescription = null,
            tint = Primary
        )
    }
}

@Composable
@Preview
fun Preview_JetIconText() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        JetIconText {}
    }
}