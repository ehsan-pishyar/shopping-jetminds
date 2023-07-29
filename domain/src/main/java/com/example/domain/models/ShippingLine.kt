package com.example.domain.models

data class ShippingLine(
    val id: Int?,
    val methodId: String?,
    val methodTitle: String?,
    val taxes: List<Tax>?,
    val total: String?,
    val totalTax: String?
)