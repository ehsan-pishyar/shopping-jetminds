package com.example.network.models

data class ProductCategoriesResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val parent: Int,
    val description: String,
    val display: String,
    val image: Image,
    val menu_order: Int,
    val count: Int,
)