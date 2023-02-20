package com.example.domain.models

data class ProductCategoriesResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val parent: Int,
    val description: String,
    val display: String,
    val image: Image,
    val menuOrder: Int,
    val count: Int,
)