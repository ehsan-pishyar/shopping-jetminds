package com.example.cache.models

import kotlinx.serialization.Serializable

@Serializable
data class ImageEntity(
    val id: Int,
    val name: String,
    val src: String,
    val alt: String
)