package com.example.network.models

import kotlinx.serialization.Serializable

@Serializable
data class TaxDto(
    val id: Int,
    val subtotal: String,
    val total: String
)