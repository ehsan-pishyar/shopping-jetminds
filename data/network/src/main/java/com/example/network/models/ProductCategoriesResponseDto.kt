package com.example.network.models

import com.google.gson.annotations.SerializedName

data class ProductCategoriesResponseDto(
    val id: Int?,
    val name: String?,
    val slug: String?,
    val parent: Int?,
    val description: String?,
    val display: String?,
    val image: ImageDto?,
    @SerializedName("menu_order")
    val menuOrder: Int?,
    val count: Int?,
)