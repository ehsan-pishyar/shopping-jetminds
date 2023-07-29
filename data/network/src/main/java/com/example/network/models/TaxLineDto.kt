package com.example.network.models

import com.google.gson.annotations.SerializedName

data class TaxLineDto(
    val id: Int?,
    val label: String?,
    val compound: Boolean?,
    @SerializedName("rate_code")
    val rateCode: String?,
    @SerializedName("rate_id")
    val rateId: Int?,
    @SerializedName("shipping_tax_total")
    val shippingTaxTotal: String?,
    @SerializedName("tax_total")
    val taxTotal: String?
)