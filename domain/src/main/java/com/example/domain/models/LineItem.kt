package com.example.domain.models

data class LineItem(
    val id: Int? = null,
    val name: String? = null,
    val price: Int? = null,
    val productId: Int? = null,
    val quantity: Int? = null,
    val sku: String? = null,
    val subtotal: String? = null,
    val subtotalTax: String? = null,
    val taxClass: String? = null,
    val taxes: List<Tax>? = null,
    val total: String? = null,
    val totalTax: String? = null,
    val variationId: Int? = null
)