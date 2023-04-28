package com.example.network.models

import com.squareup.moshi.Json

data class ProductCategoriesResponseDto(
    val id: Int? = null,
    val name: String? = null,
    val slug: String? = null,
    val parent: Int? = null,
    val description: String? = null,
    val display: String? = null,
    val image: ImageDto? = null,
    @Json(name = "menu_order")
    val menuOrder: Int? = null,
    val count: Int? = null,
)