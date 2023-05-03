package com.example.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductVariationsResponseDto(
    val id: Int,
    @SerialName("date_created")
    val dateCreated: String,
    @SerialName("date_created_gmt")
    val dateCreatedGmt: String,
    val description: String,
    val permalink: String,
    val sku: String,
    val price: String,
    @SerialName("regular_price")
    val regularPrice: String,
    @SerialName("sale_price")
    val salePrice: String,
    @SerialName("date_on_sale_from")
    val dateOnSaleFrom: String,
    @SerialName("date_on_sale_from_gmt")
    val dateOnSaleFromGmt: String,
    @SerialName("date_on_sale_to")
    val dateOnSaleTo: String,
    @SerialName("date_on_sale_to_gmt")
    val dateOnSaleToGmt: String,
    @SerialName("on_sale")
    val onSale: Boolean,
    val status: String,
    val purchasable: Boolean,
    @SerialName("tax_status")
    val taxStatus: String,
    @SerialName("tax_class")
    val taxClass: String,
    @SerialName("manage_stock")
    val manageStock: Boolean,
    @SerialName("stock_quantity")
    val stockQuantity: Int,
    @SerialName("stock_status")
    val stockStatus: String,
    @SerialName("shipping_class")
    val shippingClass: String,
    @SerialName("shipping_class_id")
    val shippingClassId: Int,
    val image: ImageDto,
    val attribute: List<AttributeDto>
)