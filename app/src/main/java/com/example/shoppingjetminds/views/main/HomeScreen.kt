package com.example.shoppingjetminds.views.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.shoppingjetminds.R
import com.example.shoppingjetminds.components.JetIconText
import com.example.shoppingjetminds.components.JetProduct
import com.example.shoppingjetminds.components.JetSectionTitle
import com.example.shoppingjetminds.components.JetText
import com.example.shoppingjetminds.ui.theme.Background


@Composable
fun HomeScreen(
    navController: NavController
    //categoriesViewModel: ProductCategoriesViewModel = hiltViewModel()
    //productsViewModel: ProductsViewModel = hiltViewModel()
){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.jetminds_slider_1),
                contentDescription = "main Banner",
                modifier = Modifier.clip(RoundedCornerShape(12.dp))
            )

            SectionSpacer(20)

            // UI Kit section start
            JetSectionTitle(title = "کیت های رابط کاربری") {}

            SectionSpacer(10)

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                userScrollEnabled = true
            ) {
                items(count = 4) {
                    JetProduct(
                        title = "کیت رابط کاربری Magenest – eCommerce App UI Kit",
                        image = R.drawable.jetminds_shop_feature_image_example,
                        price = "39000",
                        rating = "4.6",
                        category = "کیت رابط کاربری"
                    )
                }
            }
            // UI Kit section end

            SectionSpacer(20)

            // Android source code section start
            JetSectionTitle(title = "سورس کد اندروید") {}

            SectionSpacer(10)

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                userScrollEnabled = true
            ) {
                items(count = 4) {
                    JetProduct(
                        title = "کیت رابط کاربری Magenest – eCommerce App UI Kit",
                        image = R.drawable.jetminds_shop_feature_image_example,
                        price = "39000",
                        rating = "4.6",
                        category = "کیت رابط کاربری"
                    )
                }
            }
            // Android source code section end
        }
    }
}

@Composable
fun SectionSpacer(value: Int) {
    Spacer(modifier = Modifier.height(value.dp))
}


@Preview
@Composable
fun Preview_HomeScreen() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl ) {
        HomeScreen(navController = NavController(LocalContext.current))
    }
}