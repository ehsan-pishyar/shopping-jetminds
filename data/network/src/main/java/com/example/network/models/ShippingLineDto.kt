package com.example.network.models

import com.google.gson.annotations.SerializedName

data class ShippingLineDto(
    val id: Int,
    @SerializedName("method_id")
    val methodId: String,
    @SerializedName("method_title")
    val methodTitle: String,
    val taxes: List<TaxDto>,
    val total: String,
    @SerializedName("total_tax")
    val totalTax: String
)