package com.example.cache.models

import kotlinx.serialization.Serializable

@Serializable
data class TagEntity(
    val id: Int,
    val name: String
)
