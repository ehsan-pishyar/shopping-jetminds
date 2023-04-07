package com.example.shoppingjetminds.views.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.ui.theme.Background

@Composable
fun ShopScreen() {

    var search by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(15.dp)
        ) {

            // Categories
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                userScrollEnabled = true
            ) {
//                items(items = CategoriesFakeData.categories, itemContent = { items ->
//                    JetCategory(
//                        title = items.name,
//                        imageUrl = items.image?
//                    )
//                })
            }

            Spacer(modifier = Modifier.height(10.dp))

            // Filters and Order by
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier
                    .weight(1f)
                    .background(Color.White)
                    .padding(10.dp)
                ) {
                    Row {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.filter_icon),
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(20.dp))

                        JetText(
                            text = "فیلتر ها",
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14,
                            maxLines = 1,
                            lineHeight = 0.0
                        )
                    }
                }
                
                Spacer(modifier = Modifier.width(10.dp))

                Box(modifier = Modifier
                    .weight(1f)
                    .background(Color.White)
                    .padding(10.dp)
                ) {
                    Row {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.sort_icon),
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(20.dp))

                        JetText(
                            text = "مرتب سازی",
                            textAlign = TextAlign.Start,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14,
                            maxLines = 1,
                            lineHeight = 0.0
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(10.dp))


        }
    }
}

@Preview
@Composable
fun PreviewShopScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        ShopScreen()
    }
}