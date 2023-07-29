package com.example.network.models

import com.google.gson.annotations.SerializedName

data class ProductAttributesResponseDto(
    val id: Int?,
    val name: String?,
    val slug: String?,
    val type: String?,
    @SerializedName("order_by")
    val orderBy: String?,
    @SerializedName("has_archives")
    val hasArchives: Boolean?
)