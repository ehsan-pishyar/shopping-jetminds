package com.example.domain.models

data class ProductCategoriesResponse(
    val id: Int? = null,
    val name: String = "",
    val slug: String = "",
    val parent: Int = 0,
    val description: String = "",
    val display: String = "",
    val image: Image? = null,
    val menuOrder: Int = 0,
    val count: Int = 0,
)