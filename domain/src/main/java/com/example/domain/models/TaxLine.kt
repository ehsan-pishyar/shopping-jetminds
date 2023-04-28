package com.example.domain.models

data class TaxLine(
    val id: Int? = null,
    val label: String? = null,
    val compound: Boolean? = null,
    val rateCode: String? = null,
    val rateId: Int? = null,
    val shippingTaxTotal: String? = null,
    val taxTotal: String? = null
)