package com.example.domain.models

data class ProductVariationsResponse(
    val id: Int?,
    val dateCreated: String?,
    val dateCreatedGmt: String?,
    val description: String?,
    val permalink: String?,
    val sku: String?,
    val price: String?,
    val regularPrice: String?,
    val salePrice: String?,
    val dateOnSaleFrom: String?,
    val dateOnSaleFromGmt: String?,
    val dateOnSaleTo: String?,
    val dateOnSaleToGmt: String?,
    val onSale: Boolean?,
    val status: String?,
    val purchasable: Boolean?,
    val taxStatus: String?,
    val taxClass: String?,
    val manageStock: Boolean?,
    val stockQuantity: Int?,
    val stockStatus: String?,
    val shippingClass: String?,
    val shippingClassId: Int?,
    val image: Image?,
    val attributes: List<Attribute>?
)