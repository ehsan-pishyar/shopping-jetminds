package com.example.domain.models

data class CouponsResponse(
    val id: Int? = null,
    val code: String? = null,
    val amount: String? = null,
    val status: String? = null,
    val dateCreated: String? = null,
    val dateCreatedGmt: String? = null,
    val discountType: String? = null,
    val description: String? = null,
    val dateExpires: String? = null,
    val dateExpiresGmt: String? = null,
    val usageCount: Int? = null,
    val individualUse: Boolean? = null,
    val productIds: List<Int>? = null,
    val excludedProductIds: List<Int>? = null,
    val usageLimit: Int? = null,
    val usageLimitPerUser: Int? = null,
    val limitUsageToXItems: Int? = null,
    val freeShipping: Boolean? = null,
    val productCategories: List<Category>? = null,
    val excludeSaleItems: Boolean? = null,
    val maximumAmount: String? = null,
    val minimumAmount: String? = null,
    val emailRestrictions: List<String>? = null
)