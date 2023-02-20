package com.example.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponseDto(
    val id: Int,
    val name: String,
    val slug: String,
    val permalink: String,
    @SerialName("date_created")
    val dateCreated: String,
    @SerialName("date_created_gmt")
    val dateCreatedGmt: String,
    val type: String,
    val status: String,
    val featured: Boolean,
    @SerialName("catalog_visibility")
    val catalogVisibility: String,
    val description: String,
    @SerialName("short_description")
    val shortDescription: String,
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
    val purchasable: Boolean,
    @SerialName("tax_status")
    val taxStatus: String,
    @SerialName("tax_class")
    val taxClass: String,
    @SerialName("manage_stock")
    val manageStock: Boolean,
    @SerialName("stock_quantity")
    val stockQuantity: Int,
    @SerialName("sold_individually")
    val soldIndividually: Boolean,
    @SerialName("shipping_required")
    val shippingRequired: Boolean,
    @SerialName("shipping_taxable")
    val shippingTaxable: Boolean,
    @SerialName("shipping_class")
    val shippingClass: String,
    @SerialName("shipping_class_id")
    val shippingClassId: Int,
    @SerialName("reviews_allowed")
    val reviewsAllowed: Boolean,
    @SerialName("average_rating")
    val averageRating: String,
    @SerialName("rating_count")
    val ratingCount: Int,
    @SerialName("parent_id")
    val parentId: Int,
    @SerialName("purchase_note")
    val purchaseNote: String,
    val categories: List<CategoryDto>,
    val tagDtos: List<TagDto>,
    val imageDtos: List<ImageDto>,
    val attributeDtos: List<AttributeDto>,
    @SerialName("default_attributes")
    val defaultAttributeDtos: List<DefaultAttributeDto>,
    @SerialName("stock_status")
    val stockStatus: String,
    @SerialName("has_options")
    val hasOptions: Boolean
)