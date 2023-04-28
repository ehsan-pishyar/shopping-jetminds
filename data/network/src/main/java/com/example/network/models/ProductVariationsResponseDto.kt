package com.example.network.models

import com.squareup.moshi.Json

data class ProductVariationsResponseDto(
    val id: Int? = null,
    @Json(name = "date_created")
    val dateCreated: String? = null,
    @Json(name = "date_created_gmt")
    val dateCreatedGmt: String? = null,
    val description: String? = null,
    val permalink: String? = null,
    val sku: String? = null,
    val price: String? = null,
    @Json(name = "regular_price")
    val regularPrice: String? = null,
    @Json(name = "sale_price")
    val salePrice: String? = null,
    @Json(name = "date_on_sale_from")
    val dateOnSaleFrom: String? = null,
    @Json(name = "date_on_sale_from_gmt")
    val dateOnSaleFromGmt: String? = null,
    @Json(name = "date_on_sale_to")
    val dateOnSaleTo: String? = null,
    @Json(name = "date_on_sale_to_gmt")
    val dateOnSaleToGmt: String? = null,
    @Json(name = "on_sale")
    val onSale: Boolean? = null,
    val status: String? = null,
    val purchasable: Boolean? = null,
    @Json(name = "tax_status")
    val taxStatus: String? = null,
    @Json(name = "tax_class")
    val taxClass: String? = null,
    @Json(name = "manage_stock")
    val manageStock: Boolean? = null,
    @Json(name = "stock_quantity")
    val stockQuantity: Int? = null,
    @Json(name = "stock_status")
    val stockStatus: String? = null,
    @Json(name = "shipping_class")
    val shippingClass: String? = null,
    @Json(name = "shipping_class_id")
    val shippingClassId: Int? = null,
    val image: ImageDto? = null,
    val attribute: List<AttributeDto>? = null
)