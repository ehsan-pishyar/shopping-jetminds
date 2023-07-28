package com.example.network.models

import com.google.gson.annotations.SerializedName

data class ProductCategoriesResponseDto(
    val id: Int? = null,
    val name: String = "",
    val slug: String = "",
    val parent: Int = 0,
    val description: String = "",
    val display: String = "",
    val image: ImageDto? = null,
    @SerializedName("menu_order")
    val menuOrder: Int = 0,
    val count: Int = 0,
)