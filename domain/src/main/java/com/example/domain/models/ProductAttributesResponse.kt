package com.example.domain.models

data class ProductAttributesResponse(
    val id: Int,
    val name: String,
    val slug: String,
    val type: String,
    val orderBy: String,
    val hasArchives: Boolean
)