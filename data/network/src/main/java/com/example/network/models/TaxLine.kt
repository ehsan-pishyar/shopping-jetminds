package com.example.network.models

data class TaxLine(
    val id: Int,
    val label: String,
    val compound: Boolean,
    val rate_code: String,
    val rate_id: Int,
    val shipping_tax_total: String,
    val tax_total: String
)