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
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.components.*
import com.example.shoppingjetminds.ui.theme.Background
import com.example.shoppingjetminds.utils.*
import com.example.shoppingjetminds.viewmodels.*

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    navController: NavController,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    categoriesViewModel: ProductCategoriesViewModel = hiltViewModel(),
    productsViewModel: ProductsViewModel = hiltViewModel()
){

    Scaffold(
        modifier = Modifier
            .background(Background)
            .verticalScroll(rememberScrollState()),
        scaffoldState = scaffoldState
    ) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
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
                CategorySection(viewModel = categoriesViewModel)

                Spacer(modifier = Modifier.height(30.dp))

                // OnSale Products

                Spacer(modifier = Modifier.height(30.dp))

                // Technology Base Batteries Category

                Spacer(modifier = Modifier.height(30.dp))

                // Popular Products

                Spacer(modifier = Modifier.height(30.dp))

                // Device Base Batteries Category

                Spacer(modifier = Modifier.height(30.dp))

                // Top Sales Products

                Spacer(modifier = Modifier.height(30.dp))

                // Delivery Banner - ***
                Image(painter = painterResource(id = R.drawable.free_delivery_banner), contentDescription = null)

                Spacer(modifier = Modifier.height(30.dp))

                // Newest Products

                Spacer(modifier = Modifier.height(30.dp))

                // Newest Products
            }
        }
    }
}

@Composable
fun CategorySection(
    viewModel: ProductCategoriesViewModel
) {

    val state = viewModel.state.value

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
        items(state.success) {
            JetCategory(
                imageUrl = it.image.src,
                title = it.name
            )
        }
    }
}

@Composable
fun OnSaleSection(
    viewModel: ProductsViewModel
) {

    val state = viewModel

    JetIconText(title = "تخفیفات این هفته آنارام")
    Spacer(modifier = Modifier.height(10.dp))
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        userScrollEnabled = true
    ) {
//        items(items = ProductFakeData.products, itemContent = { item ->
//            JetOnSaleProduct(
//                title = item.name,
//                image = item.images[0].src,
//                regularPrice = priceThousandsSeparator(item.regularPrice),
//                salePrice = priceThousandsSeparator(item.salePrice),
//                rating = item.averageRating,
//                ratingCount = item.ratingCount,
//                countDownTimer = onSaleCountDown(item.dateOnSaleFrom, item.dateOnSaleTo)
//            )
//        })
    }
}

@Composable
fun TechnologyBasedBatteriesSection(
    viewModel: ProductsViewModel
) {

    val state = viewModel

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
}

@Composable
fun PopularSection(
    viewModel: ProductsViewModel
) {

    val state = viewModel

    JetIconText(title = "محبوب ترین های آنارام")
    Spacer(modifier = Modifier.height(10.dp))
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        userScrollEnabled = true
    ) {
//        items(items = ProductFakeData.products, itemContent = { item ->
//            JetProduct(
//                title = item.title,
//                image = item.images[0].src,
//                price = priceThousandsSeparator(item.price),
//                rating = item.averageRating,
//                ratingCount = item.ratingCount
//            )
//        })
    }
}

@Composable
fun DeviceBasedBatteriesSection(
    viewModel: ProductsViewModel
) {

    val state = viewModel

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        userScrollEnabled = true
    ) {
        items(items = DeviceBaseBatteriesFakeData.devices, itemContent = { items ->
            JetCategory2(
                modifier = Modifier
                    .size(120.dp),
                title = items.title,
                image = items.image,
                titleSize = 10
            )
        })
    }
}

@Composable
fun TopSalesSection(
    viewModel: ProductsViewModel
) {

    val state = viewModel

    JetIconText(title = "پرفروش ترین ها")
    Spacer(modifier = Modifier.height(10.dp))
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        userScrollEnabled = true
    ) {
//        items(items = ProductFakeData.products, itemContent = { item ->
//            JetProduct(
//                title = item.name,
//                image = item.images[0].src,
//                price = priceThousandsSeparator(item.price),
//                rating = item.averageRating,
//                ratingCount = item.ratingCount
//            )
//        })
    }
}

@Composable
fun NewestSection(
    viewModel: ProductsViewModel
) {

    val state = viewModel

    JetIconText(title = "جدیدترین ها")
    Spacer(modifier = Modifier.height(10.dp))
    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        userScrollEnabled = true
    ) {
//        items(items = ProductFakeData.products, itemContent = { item ->
//            JetProduct(
//                title = item.name,
//                image = item.images[0].src,
//                price = priceThousandsSeparator(item.price),
//                rating = item.averageRating,
//                ratingCount = item.ratingCount
//            )
//        })
    }
}


//@RequiresApi(Build.VERSION_CODES.O)
//@Preview
//@Composable
//fun PreviewHomeScreen() {
//    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
//        HomeScreen(navController = NavController(LocalContext.current))
//    }
//}