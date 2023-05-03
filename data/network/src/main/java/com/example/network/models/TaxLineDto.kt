package com.example.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TaxLineDto(
    val id: Int,
    val label: String,
    val compound: Boolean,
    @SerialName("rate_code")
    val rateCode: String,
    @SerialName("rate_id")
    val rateId: Int,
    @SerialName("shipping_tax_total")
    val shippingTaxTotal: String,
    @SerialName("tax_total")
    val taxTotal: String
)