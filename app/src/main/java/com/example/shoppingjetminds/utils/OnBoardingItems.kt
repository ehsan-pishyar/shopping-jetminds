package com.example.shoppingjetminds.utils

import com.example.shoppingjetminds.R

object OnBoardingItems {
    val items = listOf(
        OnBoardingData(
            image = R.drawable.jetminds_shop_feature_image_example,
            title = "آیتم اول",
            description = "لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است"
        ),
        OnBoardingData(
            image = R.drawable.jetminds_shop_feature_image_example,
            title = "آیتم دوم",
            description = "لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است"
        ),
        OnBoardingData(
            image = R.drawable.jetminds_shop_feature_image_example,
            title = "آیتم سوم",
            description = "لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است"
        )
    )
}

data class OnBoardingData(
    val image: Int,
    val title: String,
    val description: String
)