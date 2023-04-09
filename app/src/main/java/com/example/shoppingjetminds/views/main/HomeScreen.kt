package com.example.shoppingjetminds.views.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.components.*
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.utils.TechnologyBaseBatteriesFakeData
import com.example.shoppingjetminds.utils.onSaleCountDown
import com.example.shoppingjetminds.utils.priceThousandsSeparator
import com.example.shoppingjetminds.viewmodels.ProductCategoriesViewModel
import com.example.shoppingjetminds.viewmodels.ProductTagsViewModel
import com.example.shoppingjetminds.viewmodels.ProductsViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    productCategoriesViewModel: ProductCategoriesViewModel = hiltViewModel(),
    productsViewModel: ProductsViewModel = hiltViewModel(),
    productTagsViewModel: ProductTagsViewModel = hiltViewModel()
){

    val categoriesState = productCategoriesViewModel.categoriesState
    val onSaleState = productsViewModel.onSaleState
    val popularState = productsViewModel.popularState
    val topSalesState = productsViewModel.topSalesState
    val newestState = productsViewModel.newestState
    val topRatedState = productsViewModel.topRatedState

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
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    lineHeight = 0.0
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true
                ) {
                    items(items = categoriesState.categories!!, itemContent = { items ->
                        JetCategory(
                            title = items.name!!,
                            imageUrl = items.image?.src!!
                        )
                    })
                }

                Spacer(modifier = Modifier.height(30.dp))

                // OnSale Products
                JetIconText(title = "تخفیفات این هفته آنارام")

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true
                ) {
                    if (onSaleState.success) {
                        items(items = onSaleState.products!!, itemContent = { item ->
                            JetOnSaleProduct(
                                title = item.name,
                                image = item.images[0].src,
                                regularPrice = priceThousandsSeparator(item.regularPrice),
                                salePrice = priceThousandsSeparator(item.salePrice),
                                rating = item.averageRating,
                                ratingCount = item.ratingCount,
                                countDownTimer = onSaleCountDown(item.dateOnSaleFrom, item.dateOnSaleTo)
                            )
                        })
                    }

                }

                Spacer(modifier = Modifier.height(30.dp))

                // Technology Base Batteries Category
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true
                ) {
                    items(items = TechnologyBaseBatteriesFakeData.technologyBaseBatteries, itemContent = { items ->
                        Image(
                            modifier = Modifier.size(120.dp),
                            painter = painterResource(id = items.image),
                            contentDescription = null
                        )
                    })
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Popular Products
                JetIconText(title = "محبوب ترین های آنارام")

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true
                ) {
                    items(items = popularState.products!!, itemContent = { item ->
                        JetProduct(
                            title = item.name,
                            image = item.images[0].src,
                            price = priceThousandsSeparator(item.price),
                            rating = item.averageRating,
                            ratingCount = item.ratingCount
                        )
                    })
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Device Base Batteries Category
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true
                ) {
//                    items(items = , itemContent = { items ->
//                        JetCategory(
//                            modifier = Modifier
//                                .size(120.dp)
//                                .padding(5.dp),
//                            title = items.title,
//                            imageUrl = items.image?.src!!,
//                            titleSize = 10
//                        )
//                    })
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Delivery Banner - ***
                Image(painter = painterResource(id = R.drawable.free_delivery_banner), contentDescription = null)

                Spacer(modifier = Modifier.height(30.dp))

                // Top Sales Products
                JetIconText(title = "پرفروش ترین ها")

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true
                ) {
                    items(items = topSalesState.products!!, itemContent = { item ->
                        JetProduct(
                            title = item.name,
                            image = item.images[0].src,
                            price = priceThousandsSeparator(item.price),
                            rating = item.averageRating,
                            ratingCount = item.ratingCount
                        )
                    })
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Newest Products
                JetIconText(title = "جدیدترین ها")

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true
                ) {
                    items(items = newestState.products!!, itemContent = { item ->
                        JetProduct(
                            title = item.name,
                            image = item.images[0].src,
                            price = priceThousandsSeparator(item.price),
                            rating = item.averageRating,
                            ratingCount = item.ratingCount
                        )
                    })
                }

                Spacer(modifier = Modifier.height(30.dp))

                // Newest Products
                JetIconText(title = "برترین ها")

                Spacer(modifier = Modifier.height(10.dp))

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    userScrollEnabled = true
                ) {
                    items(items = topRatedState.products!!, itemContent = { item ->
                        JetProduct(
                            title = item.name,
                            image = item.images[0].src,
                            price = priceThousandsSeparator(item.price),
                            rating = item.averageRating,
                            ratingCount = item.ratingCount
                        )
                    })
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewHomeScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        HomeScreen(

        )
    }
}