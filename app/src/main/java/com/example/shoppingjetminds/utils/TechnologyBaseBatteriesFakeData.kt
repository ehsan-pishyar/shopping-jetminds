package com.example.shoppingjetminds.utils

import com.example.shoppingjetminds.R

object TechnologyBaseBatteriesFakeData {
    val technologyBaseBatteries = listOf(
        FakeTechnologyBaseBatteries(image = R.drawable.tag_alkaline),
        FakeTechnologyBaseBatteries(image = R.drawable.tag_lithium),
        FakeTechnologyBaseBatteries(image = R.drawable.tag_zinc),
        FakeTechnologyBaseBatteries(image = R.drawable.tag_roy),
    )
}

data class FakeTechnologyBaseBatteries(
    val image: Int
)