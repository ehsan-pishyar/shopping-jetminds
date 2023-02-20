package com.example.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LineItemDto(
    val id: Int,
    val name: String,
    val price: Int,
    @SerialName("product_id")
    val productId: Int,
    val quantity: Int,
    val sku: String,
    val subtotal: String,
    @SerialName("subtotal_tax")
    val subtotalTax: String,
    @SerialName("tax_class")
    val taxClass: String,
    val taxDtos: List<TaxDto>,
    val total: String,
    @SerialName("total_tax")
    val totalTax: String,
    @SerialName("variation_id")
    val variationId: Int
)