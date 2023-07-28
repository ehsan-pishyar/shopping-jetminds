package com.example.network.models

import com.google.gson.annotations.SerializedName

data class LineItemDto(
    val id: Int,
    val name: String,
    val price: Int,
    @SerializedName("product_id")
    val productId: Int,
    val quantity: Int,
    val sku: String,
    val subtotal: String,
    @SerializedName("subtotal_tax")
    val subtotalTax: String,
    @SerializedName("tax_class")
    val taxClass: String,
    val taxes: List<TaxDto>,
    val total: String,
    @SerializedName("total_tax")
    val totalTax: String,
    @SerializedName("variation_id")
    val variationId: Int
)