package com.example.shoppingjetminds.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoppingjetminds.ui.theme.Primary

@Composable
fun LikeButton() {
    Box(modifier = Modifier.padding(5.dp)) {
        Button(modifier = Modifier
            .size(25.dp),
            contentPadding = PaddingValues(5.dp),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Primary
            ),
            onClick = {}
        ) {
            Image(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                colorFilter = ColorFilter.tint(color = Color.White)
            )
        }
    }
}

@Composable
fun BuyButton() {
    Button(modifier = Modifier
        .fillMaxSize(),
        contentPadding = PaddingValues(5.dp),
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Primary
        ),
        onClick = {}
    ) {
        Image(
            imageVector = Icons.Filled.Add,
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            colorFilter = ColorFilter.tint(color = Color.White)
        )
    }
}

@Preview
@Composable
fun Preview_LikeButton() {
    LikeButton()
}

@Preview
@Composable
fun Preview_BuyButton() {
    BuyButton()
}