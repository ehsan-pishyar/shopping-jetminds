package com.example.shoppingjetminds.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.ui.theme.RedColor
import com.example.shoppingjetminds.ui.theme.Yekanbakh

@Composable
fun JetDiscount(
    modifier: Modifier = Modifier,
    discountAmount: Int,
    discountAmountSize: Int = 14
) {
    Box {
        Card(
            modifier = modifier.size(width = 40.dp, height = 20.dp),
            backgroundColor = RedColor,
            shape = RoundedCornerShape(3.dp)
        ) {
            Row(
                modifier = modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = modifier.wrapContentWidth(),
                    text = "$discountAmount",
                    fontSize = (discountAmountSize).sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = Yekanbakh,
                    color = Background
                )
                
                Spacer(modifier = modifier.width(2.dp))

                Icon(
                    modifier = modifier.size(8.dp),
                    painter = painterResource(id = R.drawable.percent),
                    contentDescription = null,
                    tint = Background
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewJetDiscount() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        JetDiscount(discountAmount = 35)
    }
}