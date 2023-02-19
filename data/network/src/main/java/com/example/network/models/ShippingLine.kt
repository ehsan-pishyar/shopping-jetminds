package com.example.network.models

data class ShippingLine(
    val id: Int,
    val method_id: String,
    val method_title: String,
    val taxes: List<Any>,
    val total: String,
    val total_tax: String
)