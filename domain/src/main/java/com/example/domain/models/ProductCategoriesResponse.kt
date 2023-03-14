package com.example.domain.models

data class ProductCategoriesResponse(
    val id: Int? = null,
    val name: String? = null,
    val slug: String? = null,
    val parent: Int? = null,
    val description: String? = null,
    val display: String? = null,
    val image: Image? = null,
    val menuOrder: Int? = null,
    val count: Int? = null,
)