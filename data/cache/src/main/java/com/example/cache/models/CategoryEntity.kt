package com.example.cache.models

import kotlinx.serialization.Serializable

@Serializable
data class CategoryEntity(
    val id: Int,
    val name: String
)