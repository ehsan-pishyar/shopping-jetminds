package com.example.shoppingjetminds.utils

import com.example.shoppingjetminds.R

object ProductFakeData {

    val products = listOf(
        FakeProduct(
            title = "باتری شارژی قلمی وارتا 2100 میلی آمپر",
            image = R.drawable.varta_recharge_accu_power_aa_2100mah,
            price = 120000,
            rating = 4.5
        ),
        FakeProduct(
            title = "باتری شارژی قلمی وارتا 2100 میلی آمپر",
            image = R.drawable.varta_recharge_accu_power_aa_2100mah,
            price = 90000,
            rating = 3.2
        ),
        FakeProduct(
            title = "باتری شارژی قلمی وارتا 2100 میلی آمپر",
            image = R.drawable.varta_recharge_accu_power_aa_2100mah,
            price = 100000,
            rating = 4.3
        ),
        FakeProduct(
            title = "باتری شارژی قلمی وارتا 2100 میلی آمپر",
            image = R.drawable.varta_recharge_accu_power_aa_2100mah,
            price = 150000,
            rating = 5.0
        ),
        FakeProduct(
            title = "باتری شارژی قلمی وارتا 2100 میلی آمپر",
            image = R.drawable.varta_recharge_accu_power_aa_2100mah,
            price = 85000,
            rating = 2.0
        )
    )
}

data class FakeProduct(
    val title: String,
    val image: Int?,
    val price: Int?,
    val rating: Double?,
)