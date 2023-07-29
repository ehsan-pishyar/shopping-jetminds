package com.example.network.models

import com.google.gson.annotations.SerializedName

data class CouponsResponseDto(
    val id: Int?,
    val code: String?,
    val amount: String?,
    val status: String?,
    @SerializedName("date_created")
    val dateCreated: String?,
    @SerializedName("date_created_gmt")
    val dateCreatedGmt: String?,
    @SerializedName("discount_type")
    val discountType: String?,
    val description: String?,
    @SerializedName("date_expires")
    val dateExpires: String?,
    @SerializedName("date_expires_gmt")
    val dateExpiresGmt: String?,
    @SerializedName("usage_count")
    val usageCount: Int?,
    @SerializedName("individual_use")
    val individualUse: Boolean?,
    @SerializedName("product_ids")
    val productIds: List<Int>?,
    @SerializedName("excluded_product_ids")
    val excludedProductIds: List<Int>?,
    @SerializedName("usage_limit")
    val usageLimit: Int?,
    @SerializedName("usage_limit_per_user")
    val usageLimitPerUser: Int?,
    @SerializedName("limit_usage_to_x_items")
    val limitUsageToXItems: Int?,
    @SerializedName("free_shipping")
    val freeShipping: Boolean?,
    @SerializedName("product_categories")
    val productCategories: List<CategoryDto>?,
    @SerializedName("exclude_sale_items")
    val excludeSaleItems: Boolean?,
    @SerializedName("maximum_amount")
    val maximumAmount: String?,
    @SerializedName("minimum_amount")
    val minimumAmount: String?,
    @SerializedName("email_restrictions")
    val emailRestrictions: List<String>?
)