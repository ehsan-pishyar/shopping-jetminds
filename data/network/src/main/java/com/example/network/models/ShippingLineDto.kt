package com.example.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShippingLineDto(
    val id: Int,
    @SerialName("method_id")
    val methodId: String,
    @SerialName("method_title")
    val methodTitle: String,
    val taxes: List<TaxDto>,
    val total: String,
    @SerialName("total_tax")
    val totalTax: String
)