package com.example.cache.models

import kotlinx.serialization.Serializable

@Serializable
data class TaxEntity(
    val id: Int?,
    val subtotal: String?,
    val total: String?
)