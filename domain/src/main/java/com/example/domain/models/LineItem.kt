package com.example.domain.models

data class LineItem(
    val id: Int,
    val name: String,
    val price: Int,
    val productId: Int,
    val quantity: Int,
    val sku: String,
    val subtotal: String,
    val subtotalTax: String,
    val taxClass: String,
    val taxes: List<Taxe>,
    val total: String,
    val totalTax: String,
    val variationId: Int
)