package com.example.domain.models

data class TaxLine(
    val id: Int,
    val label: String,
    val compound: Boolean,
    val meta_data: List<MetaData>,
    val rate_code: String,
    val rate_id: Int,
    val shipping_tax_total: String,
    val tax_total: String
)