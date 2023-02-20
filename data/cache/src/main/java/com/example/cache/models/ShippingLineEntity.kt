package com.example.cache.models

data class ShippingLineEntity(
    val id: Int,
    val method_id: String,
    val method_title: String,
    val taxes: List<Any>,
    val total: String,
    val total_tax: String
)