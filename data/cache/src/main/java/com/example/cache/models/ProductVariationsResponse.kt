package com.example.cache.models

data class ProductVariationsResponse(
    val id: Int,
    val date_created: String,
    val date_created_gmt: String,
    val description: String,
    val permalink: String,
    val sku: String,
    val price: String,
    val regular_price: String,
    val sale_price: String,
    val date_on_sale_from: String,
    val date_on_sale_from_gmt: String,
    val date_on_sale_to: String,
    val date_on_sale_to_gmt: String,
    val on_sale: Boolean,
    val status: String,
    val purchasable: Boolean,
    val tax_status: String,
    val tax_class: String,
    val manage_stock: Boolean,
    val stock_quantity: Any,
    val stock_status: String,
    val shipping_class: String,
    val shipping_class_id: Int,
    val image: Image,
    val attributes: List<Attribute>
)