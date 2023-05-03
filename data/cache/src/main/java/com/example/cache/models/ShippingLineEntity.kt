package com.example.cache.models

import kotlinx.serialization.Serializable

@Serializable
data class ShippingLineEntity(
    val id: Int,
    val methodId: String,
    val methodTitle: String,
    val taxes: List<TaxEntity>,
    val total: String,
    val totalTax: String
)