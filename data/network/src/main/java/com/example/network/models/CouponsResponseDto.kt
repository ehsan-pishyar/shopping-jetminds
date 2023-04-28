package com.example.network.models

import com.squareup.moshi.Json


data class CouponsResponseDto(
    val id: Int? = null,
    val code: String? = null,
    val amount: String? = null,
    val status: String? = null,
    @Json(name = "date_created")
    val dateCreated: String? = null,
    @Json(name = "date_created_gmt")
    val dateCreatedGmt: String? = null,
    @Json(name = "discount_type")
    val discountType: String? = null,
    val description: String? = null,
    @Json(name = "date_expires")
    val dateExpires: String? = null,
    @Json(name = "date_expires_gmt")
    val dateExpiresGmt: String? = null,
    @Json(name = "usage_count")
    val usageCount: Int? = null,
    @Json(name = "individual_use")
    val individualUse: Boolean? = null,
    @Json(name = "product_ids")
    val productIds: List<Int>? = null,
    @Json(name = "excluded_product_ids")
    val excludedProductIds: List<Int>? = null,
    @Json( name = "usage_limit")
    val usageLimit: Int? = null,
    @Json(name = "usage_limit_per_user")
    val usageLimitPerUser: Int? = null,
    @Json(name = "limit_usage_to_x_items")
    val limitUsageToXItems: Int? = null,
    @Json(name = "free_shipping")
    val freeShipping: Boolean? = null,
    @Json(name = "product_categories")
    val productCategories: List<CategoryDto>? = null,
    @Json(name = "exclude_sale_items")
    val excludeSaleItems: Boolean? = null,
    @Json(name = "maximum_amount")
    val maximumAmount: String? = null,
    @Json(name = "minimum_amount")
    val minimumAmount: String? = null,
    @Json( name = "email_restrictions")
    val emailRestrictions: List<String>? = null
)