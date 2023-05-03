package com.example.network.models

import kotlinx.serialization.Serializable

@Serializable
data class ImageDto(
    val id: Int,
    val name: String,
    val src: String,
    val alt: String,
)