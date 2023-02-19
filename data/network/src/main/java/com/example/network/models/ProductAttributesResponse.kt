package com.example.network.models

data class ProductAttributesResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val type: String,
    val order_by: String,
    val has_archives: Boolean
)