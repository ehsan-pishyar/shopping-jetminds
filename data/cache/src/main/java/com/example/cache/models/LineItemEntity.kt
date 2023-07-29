package com.example.cache.models

import kotlinx.serialization.Serializable

@Serializable
data class LineItemEntity(
    val id: Int?,
    val name: String?,
    val price: Int?,
    val productId: Int?,
    val quantity: Int?,
    val sku: String?,
    val subtotal: String?,
    val subtotalTax: String?,
    val taxClass: String?,
    val taxes: List<TaxEntity>?,
    val total: String?,
    val totalTax: String?,
    val variationId: Int?
)