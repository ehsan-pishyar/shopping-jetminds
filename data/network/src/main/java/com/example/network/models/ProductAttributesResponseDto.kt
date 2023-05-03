package com.example.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductAttributesResponseDto(
    val id: Int,
    val name: String,
    val slug: String,
    val type: String,
    @SerialName("order_by")
    val orderBy: String,
    @SerialName("has_archives")
    val hasArchives: Boolean
)