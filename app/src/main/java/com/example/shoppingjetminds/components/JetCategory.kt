package com.example.shoppingjetminds.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingjetminds.R

@Composable
fun JetCategory(
    modifier: Modifier = Modifier,
    navController: NavController? = null,
    title: String = "باتری وارتا",
    image: Int = R.drawable.category_9v,
    titleSize: Int = 12
) {
    Box {
        Column {
            Card(
                modifier = modifier
                    .size(120.dp),
                shape = RoundedCornerShape(10.dp)
            ) {
                Column(
                    modifier = modifier.padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = image), contentDescription = "category image")

                    JetText(
                        text = title,
                        fontSize = 12,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewJetCategory() {
    JetCategory()
}