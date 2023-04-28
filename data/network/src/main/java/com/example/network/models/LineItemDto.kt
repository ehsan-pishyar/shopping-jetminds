package com.example.network.models

import com.squareup.moshi.Json

data class LineItemDto(
    val id: Int? = null,
    val name: String? = null,
    val price: Int? = null,
    @Json(name = "product_id")
    val productId: Int? = null,
    val quantity: Int? = null,
    val sku: String? = null,
    val subtotal: String? = null,
    @Json(name = "subtotal_tax")
    val subtotalTax: String? = null,
    @Json(name = "tax_class")
    val taxClass: String? = null,
    val taxes: List<TaxDto>? = null,
    val total: String? = null,
    @Json(name = "total_tax")
    val totalTax: String? = null,
    @Json(name = "variation_id")
    val variationId: Int? = null
)