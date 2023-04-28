package com.example.network.models

import com.squareup.moshi.Json

data class ProductAttributesResponseDto(
    val id: Int? = null,
    val name: String? = null,
    val slug: String? = null,
    val type: String? = null,
    @Json(name = "order_by")
    val orderBy: String? = null,
    @Json(name = "has_archives")
    val hasArchives: Boolean? = null
)