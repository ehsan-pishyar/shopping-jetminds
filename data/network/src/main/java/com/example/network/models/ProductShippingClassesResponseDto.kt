package com.example.network.models

import kotlinx.serialization.Serializable

@Serializable
data class ProductShippingClassesResponseDto(
    val id: Int,
    val name: String,
    val slug: String,
    val description: String,
    val count: Int
)