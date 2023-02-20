package com.example.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CouponsResponseDto(
    val id: Int,
    val code: String,
    val amount: String,
    val status: String,
    @SerialName("date_created")
    val dateCreated: String,
    @SerialName("date_created_gmt")
    val dateCreatedGmt: String,
    @SerialName("discount_type")
    val discountType: String,
    val description: String,
    @SerialName("date_expires")
    val dateExpires: String,
    @SerialName("date_expires_gmt")
    val dateExpiresGmt: String,
    @SerialName("usage_count")
    val usageCount: Int,
    @SerialName("individual_use")
    val individualUse: Boolean,
    @SerialName("product_ids")
    val productIds: List<Int>,
    @SerialName("excluded_product_ids")
    val excludedProductIds: List<Int>,
    @SerialName("usage_limit")
    val usageLimit: Int,
    @SerialName("usage_limit_per_user")
    val usageLimitPerUser: Int,
    @SerialName("limit_usage_to_x_items")
    val limitUsageToXItems: Int,
    @SerialName("free_shipping")
    val freeShipping: Boolean,
    @SerialName("product_categories")
    val productCategories: List<CategoryDto>,
    @SerialName("exclude_sale_items")
    val excludeSaleItems: Boolean,
    @SerialName("maximum_amount")
    val maximumAmount: String,
    @SerialName("minimum_amount")
    val minimumAmount: String,
    @SerialName("email_restrictions")
    val emailRestrictions: List<String>
)