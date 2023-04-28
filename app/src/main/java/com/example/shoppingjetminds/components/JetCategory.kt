package com.example.shoppingjetminds.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoppingjetminds.R

@Composable
fun JetCategory(
    modifier: Modifier = Modifier,
    title: String = "باتری وارتا",
    imageUrl: String = "",
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
                    JetCoilImage(imageUrl = imageUrl)

                    JetText(
                        text = title,
                        fontSize = titleSize,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        lineHeight = 0.0
                    )
                }
            }
        }
    }
}

@Composable
fun JetCategory2(
    modifier: Modifier = Modifier,
    title: String = "باتری وارتا",
    image: Int = R.drawable.category_aa,
    titleSize: Int = 12
) {
    Box {
        Column {
            Card(
                modifier = modifier
                    .size(120.dp),
                shape = RoundedCornerShape(10.dp),
                elevation = 0.dp
            ) {
                Column(
                    modifier = modifier.padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier.size(70.dp),
                        painter = painterResource(id = image),
                        contentDescription = null
                    )

                    JetText(
                        text = title,
                        fontSize = titleSize,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        lineHeight = 0.0
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