package com.example.cache.models

data class ShippingLineEntity(
    val id: Int? = null,
    val methodId: String? = null,
    val methodTitle: String? = null,
    val taxes: List<TaxEntity>? = null,
    val total: String? = null,
    val totalTax: String? = null
)