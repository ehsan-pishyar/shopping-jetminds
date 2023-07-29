package com.example.domain.models

data class TaxLine(
    val id: Int?,
    val label: String?,
    val compound: Boolean?,
    val rateCode: String?,
    val rateId: Int?,
    val shippingTaxTotal: String?,
    val taxTotal: String?
)