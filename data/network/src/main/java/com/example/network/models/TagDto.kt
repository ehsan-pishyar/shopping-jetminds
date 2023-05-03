package com.example.network.models

import kotlinx.serialization.Serializable

@Serializable
data class TagDto(
    val id: Int,
    val name: String
)
