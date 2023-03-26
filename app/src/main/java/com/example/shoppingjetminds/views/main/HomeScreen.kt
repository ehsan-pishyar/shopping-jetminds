package com.example.shoppingjetminds.views.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.components.JetCategory
import com.example.shoppingjetminds.components.JetIconText
import com.example.shoppingjetminds.components.JetProduct
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.utils.CategoriesFakeData
import com.example.shoppingjetminds.utils.ProductFakeData

@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier
            .padding(15.dp)
            .background(Background)
            .verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            // Banner
            Box(modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFf6f6f6))
            ) {
                Column {
                    Image(painter = painterResource(id = R.drawable.anaram_main_banner), contentDescription = "main banner")
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                Spacer(modifier = Modifier.height(10.dp))
                
                // Categories
                JetText(
                    modifier = Modifier.fillMaxWidth(),
                    text = "انواع باتری وارتا",
                    fontSize = 16,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true
                ) {
                    items(items = CategoriesFakeData.categories, itemContent = { items ->
                        JetCategory(
                            title = items.name,
                            image = items.image!!
                        )
                    })
                }

                Spacer(modifier = Modifier.height(50.dp))

                // OffSale Products
                JetIconText(
                    title = "تخفیفات این هفته آنارام"
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true
                ) {
                    items(items = ProductFakeData.products, itemContent = { items ->
                        JetProduct(
                            title = items.title,
                            image = items.image,
                            price = items.price,
                            rating = items.rating
                        )
                    })
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewHomeScreen() {
    HomeScreen()
}