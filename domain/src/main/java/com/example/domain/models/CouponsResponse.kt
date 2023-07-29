package com.example.domain.models

data class CouponsResponse(
    val id: Int?,
    val code: String?,
    val amount: String?,
    val status: String?,
    val dateCreated: String?,
    val dateCreatedGmt: String?,
    val discountType: String?,
    val description: String?,
    val dateExpires: String?,
    val dateExpiresGmt: String?,
    val usageCount: Int?,
    val individualUse: Boolean?,
    val productIds: List<Int>?,
    val excludedProductIds: List<Int>?,
    val usageLimit: Int?,
    val usageLimitPerUser: Int?,
    val limitUsageToXItems: Int?,
    val freeShipping: Boolean?,
    val productCategories: List<Category>?,
    val excludeSaleItems: Boolean?,
    val maximumAmount: String?,
    val minimumAmount: String?,
    val emailRestrictions: List<String>?
)