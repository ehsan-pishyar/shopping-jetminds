package com.example.domain.models

data class ProductVariationsResponse(
    val id: Int? = null,
    val dateCreated: String? = null,
    val dateCreatedGmt: String? = null,
    val description: String? = null,
    val permalink: String? = null,
    val sku: String? = null,
    val price: String? = null,
    val regularPrice: String? = null,
    val salePrice: String? = null,
    val dateOnSaleFrom: String? = null,
    val dateOnSaleFromGmt: String? = null,
    val dateOnSaleTo: String? = null,
    val dateOnSaleToGmt: String? = null,
    val onSale: Boolean? = null,
    val status: String? = null,
    val purchasable: Boolean? = null,
    val taxStatus: String? = null,
    val taxClass: String? = null,
    val manageStock: Boolean? = null,
    val stockQuantity: Int? = null,
    val stockStatus: String? = null,
    val shippingClass: String? = null,
    val shippingClassId: Int? = null,
    val image: Image? = null,
    val attributes: List<Attribute>? = null
)