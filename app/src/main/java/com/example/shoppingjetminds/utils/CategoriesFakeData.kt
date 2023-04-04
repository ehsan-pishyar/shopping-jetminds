package com.example.shoppingjetminds.utils

import com.example.shoppingjetminds.R

object CategoriesFakeData {

    val categories = listOf(
        FakeCategory(
            id = 1,
            name = "باتری قلمی",
            image = R.drawable.category_aa
        ),
        FakeCategory(
            id = 2,
            name = "باتری نیم قلمی",
            image = R.drawable.category_aaa
        ),
        FakeCategory(
            id = 3,
            name = "باتری متوسط",
            image = R.drawable.category_c
        ),
        FakeCategory(
            id = 4,
            name = "باتری بزرگ",
            image = R.drawable.category_d
        ),
        FakeCategory(
            id = 5,
            name = "باتری کتابی",
            image = R.drawable.category_9v
        ),
        FakeCategory(
            id = 6,
            name = "باتری سکه ای",
            image = R.drawable.category_coin
        )
    )
}

data class FakeCategory(
    val id: Int? = null,
    val name: String,
    val image: Int? = null
)