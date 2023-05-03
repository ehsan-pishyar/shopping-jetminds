package com.example.cache.models

import kotlinx.serialization.Serializable

@Serializable
data class TaxLineEntity(
    val id: Int,
    val label: String,
    val compound: Boolean,
    val rateCode: String,
    val rateId: Int,
    val shippingTaxTotal: String,
    val taxTotal: String
)