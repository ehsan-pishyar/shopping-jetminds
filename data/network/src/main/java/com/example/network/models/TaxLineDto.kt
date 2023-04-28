package com.example.network.models

import com.squareup.moshi.Json

data class TaxLineDto(
    val id: Int? = null,
    val label: String? = null,
    val compound: Boolean? = null,
    @Json(name = "rate_code")
    val rateCode: String? = null,
    @Json(name = "rate_id")
    val rateId: Int? = null,
    @Json(name = "shipping_tax_total")
    val shippingTaxTotal: String? = null,
    @Json(name = "tax_total")
    val taxTotal: String? = null
)