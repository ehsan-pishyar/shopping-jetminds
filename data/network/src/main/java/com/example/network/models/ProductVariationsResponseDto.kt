package com.example.network.models

import com.google.gson.annotations.SerializedName

data class ProductVariationsResponseDto(
    val id: Int?,
    @SerializedName("date_created")
    val dateCreated: String?,
    @SerializedName("date_created_gmt")
    val dateCreatedGmt: String?,
    val description: String?,
    val permalink: String?,
    val sku: String?,
    val price: String?,
    @SerializedName("regular_price")
    val regularPrice: String?,
    @SerializedName("sale_price")
    val salePrice: String?,
    @SerializedName("date_on_sale_from")
    val dateOnSaleFrom: String?,
    @SerializedName("date_on_sale_from_gmt")
    val dateOnSaleFromGmt: String?,
    @SerializedName("date_on_sale_to")
    val dateOnSaleTo: String?,
    @SerializedName("date_on_sale_to_gmt")
    val dateOnSaleToGmt: String?,
    @SerializedName("on_sale")
    val onSale: Boolean?,
    val status: String?,
    val purchasable: Boolean?,
    @SerializedName("tax_status")
    val taxStatus: String?,
    @SerializedName("tax_class")
    val taxClass: String?,
    @SerializedName("manage_stock")
    val manageStock: Boolean?,
    @SerializedName("stock_quantity")
    val stockQuantity: Int?,
    @SerializedName("stock_status")
    val stockStatus: String?,
    @SerializedName("shipping_class")
    val shippingClass: String?,
    @SerializedName("shipping_class_id")
    val shippingClassId: Int?,
    val image: ImageDto?,
    val attribute: List<AttributeDto>?
)