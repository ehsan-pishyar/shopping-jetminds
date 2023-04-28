package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.COUPONS_TABLE)
data class CouponsResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    val code: String? = null,
    val amount: String? = null,
    val status: String? = null,
    @ColumnInfo(name = "date_created")
    val dateCreated: String? = null,
    @ColumnInfo(name = "date_created_gmt")
    val dateCreatedGmt: String? = null,
    @ColumnInfo(name = "discount_type")
    val discountType: String? = null,
    val description: String? = null,
    @ColumnInfo(name = "date_expires")
    val dateExpires: String? = null,
    @ColumnInfo(name = "date_expires_gmt")
    val dateExpiresGmt: String? = null,
    @ColumnInfo(name = "usage_count")
    val usageCount: Int? = null,
    @ColumnInfo(name = "individual_use")
    val individualUse: Boolean? = null,
    @ColumnInfo(name = "product_ids")
    val productIds: List<Int>? = null,
    @ColumnInfo(name = "excluded_product_ids")
    val excludedProductIds: List<Int>? = null,
    @ColumnInfo(name = "usage_limit")
    val usageLimit: Int? = null,
    @ColumnInfo(name = "usage_limit_per_user")
    val usageLimitPerUser: Int? = null,
    @ColumnInfo(name = "limit_usage_to_x_items")
    val limitUsageToXItems: Int? = null,
    @ColumnInfo(name = "free_shipping")
    val freeShipping: Boolean? = null,
    @ColumnInfo(name = "product_categories")
    val productCategories: List<CategoryEntity>? = null,
    @ColumnInfo(name = "exclude_sale_items")
    val excludeSaleItems: Boolean? = null,
    @ColumnInfo(name = "maximum_amount")
    val maximumAmount: String? = null,
    @ColumnInfo(name = "minimum_amount")
    val minimumAmount: String? = null,
    @ColumnInfo(name = "email_restrictions")
    val emailRestrictions: List<String>? = null
)