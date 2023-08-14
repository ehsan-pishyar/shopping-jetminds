package com.example.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.designsystem.Primary
import com.example.designsystem.R
import com.example.designsystem.components.JetCoilImage
import com.example.designsystem.components.JetText

@Composable
fun JetCategory(
    imagePath: String? = null,
    title: String
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(120.dp),
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(modifier = Modifier
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (imagePath.isNullOrEmpty()) {
                Image(
                    painter = painterResource(id = R.drawable.category_default_image),
                    contentDescription = "category image",
                    contentScale = ContentScale.Crop
                )
            } else {
                JetCoilImage(
                    imageUrl = imagePath
                )
            }
            Column(
                Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Primary.copy(alpha = 0.5f)
                            )
                        )
                    ),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.Start
            ) {
                JetText(
                    text = title,
                    fontSize = 14,
                    modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp),
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
    }
}