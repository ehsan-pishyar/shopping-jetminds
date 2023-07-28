package com.example.network.models

data class ProductTagsResponseDto(
    val id: Int,
    val name: String,
    val slug: String,
    val description: String,
    val count: Int
)