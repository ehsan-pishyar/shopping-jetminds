package com.example.domain.models

data class ShippingLine(
    val id: Int? = null,
    val methodId: String? = null,
    val methodTitle: String? = null,
    val taxes: List<Tax>? = null,
    val total: String? = null,
    val totalTax: String? = null
)