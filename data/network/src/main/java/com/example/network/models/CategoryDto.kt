package com.example.network.models

import kotlinx.serialization.Serializable

@Serializable
data class CategoryDto(
    val id: Int,
    val name: String
)