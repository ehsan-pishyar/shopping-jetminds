package com.example.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductCategoriesResponseDto(
    val id: Int,
    val name: String,
    val slug: String,
    val parent: Int,
    val description: String,
    val display: String,
    val image: ImageDto,
    @SerialName("menu_order")
    val menuOrder: Int,
    val count: Int,
)