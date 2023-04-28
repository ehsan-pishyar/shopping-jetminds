package com.example.network.models

import com.squareup.moshi.Json

data class ShippingLineDto(
    val id: Int? = null,
    @Json(name = "method_id")
    val methodId: String? = null,
    @Json(name = "method_title")
    val methodTitle: String? = null,
    val taxes: List<TaxDto>? = null,
    val total: String? = null,
    @Json(name = "total_tax")
    val totalTax: String? = null
)