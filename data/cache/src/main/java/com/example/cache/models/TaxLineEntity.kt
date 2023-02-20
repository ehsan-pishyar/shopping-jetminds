package com.example.cache.models

data class TaxLineEntity(
    val id: Int,
    val label: String,
    val compound: Boolean,
    val rate_code: String,
    val rate_id: Int,
    val shipping_tax_total: String,
    val tax_total: String
)