package com.example.cache.models

data class LineItemEntity(
    val id: Int? = null,
    val name: String? = null,
    val price: Int? = null,
    val productId: Int? = null,
    val quantity: Int? = null,
    val sku: String? = null,
    val subtotal: String? = null,
    val subtotalTax: String? = null,
    val taxClass: String? = null,
    val taxes: List<TaxEntity>? = null,
    val total: String? = null,
    val totalTax: String? = null,
    val variationId: Int? = null
)