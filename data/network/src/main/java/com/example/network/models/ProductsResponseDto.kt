package com.example.network.models

import com.squareup.moshi.Json

data class ProductsResponseDto(
    val id: Int? = null,
    val name: String? = null,
    val slug: String? = null,
    @Json(name = "date_created")
    val dateCreated: String? = null,
    val type: String? = null,
    val status: String? = null,
    val featured: Boolean? = null,
    @Json(name = "catalog_visibility")
    val catalogVisibility: String? = null,
    val description: String? = null,
    @Json(name = "short_description")
    val shortDescription: String? = null,
    val sku: String? = null,
    val price: String? = null,
    @Json(name = "regular_price")
    val regularPrice: String? = null,
    @Json(name = "sale_price")
    val salePrice: String? = null,
    @Json(name = "date_on_sale_from")
    val dateOnSaleFrom: String? = null,
    @Json(name = "date_on_sale_to")
    val dateOnSaleTo: String? = null,
    @Json(name = "on_sale")
    val onSale: Boolean? = null,
    val purchasable: Boolean? = null,
    @Json(name = "total_sales")
    val totalSales: Int? = null,
    @Json(name = "tax_status")
    val taxStatus: String? = null,
    @Json(name = "tax_class")
    val taxClass: String? = null,
    @Json(name = "manage_stock")
    val manageStock: Boolean? = null,
    @Json(name = "stock_quantity")
    val stockQuantity: Int? = null,
    @Json(name = "sold_individually")
    val soldIndividually: Boolean? = null,
    @Json(name = "shipping_required")
    val shippingRequired: Boolean? = null,
    @Json(name = "shipping_taxable")
    val shippingTaxable: Boolean? = null,
    @Json(name = "shipping_class")
    val shippingClass: String? = null,
    @Json(name = "shipping_class_id")
    val shippingClassId: Int? = null,
    @Json(name = "reviews_allowed")
    val reviewsAllowed: Boolean? = null,
    @Json(name = "average_rating")
    val averageRating: String? = null,
    @Json(name = "rating_count")
    val ratingCount: Int? = null,
    val categories: List<CategoryDto>? = null,
    val tags: List<TagDto>? = null,
    val images: List<ImageDto>? = null,
    val attributes: List<AttributeDto>? = null,
    @Json(name = "default_attributes")
    val defaultAttributes: List<DefaultAttributeDto>? = null,
    @Json(name = "stock_status")
    val stockStatus: String? = null
)