package com.example.shoppingjetminds.utils

import com.example.domain.models.Image
import com.example.domain.models.ProductCategoriesResponse
import com.example.shoppingjetminds.R

object CategoriesFakeData {

    val categories = listOf<ProductCategoriesResponse>(
        ProductCategoriesResponse(
            id = 1,
            name = "باتری قلمی",
            image = Image(
                id = 11,
                name = "battery_aa",
                src = ""
            )
        ),
        ProductCategoriesResponse(
            id = 2,
            name = "باتری نیم قلمی",
            image = Image(
                id = 22,
                name = "battery_aaa",
                src = ""
            )
        ),
        ProductCategoriesResponse(
            id = 3,
            name = "باتری متوسط",
            image = Image(
                id = 33,
                name = "battery_c",
                src = ""
            )
        ),
        ProductCategoriesResponse(
            id = 4,
            name = "باتری بزرگ",
            image = Image(
                id = 44,
                name = "battery_d",
                src = ""
            )
        ),
        ProductCategoriesResponse(
            id = 5,
            name = "باتری کتابی",
            image = Image(
                id = 55,
                name = "battery_9v",
                src = ""
            )
        ),
        ProductCategoriesResponse(
            id = 6,
            name = "باتری سکه ای",
            image = Image(
                id = 66,
                name = "battery_coin",
                src = ""
            )
        ),
    )
}