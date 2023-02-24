package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.COUPONS_TABLE)
data class CouponsResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val code: String,
    val amount: String,
    val status: String,
    @ColumnInfo(name = "date_created")
    val dateCreated: String,
    @ColumnInfo(name = "date_created_gmt")
    val dateCreatedGmt: String,
    @ColumnInfo(name = "discount_type")
    val discountType: String,
    val description: String,
    @ColumnInfo(name = "date_expires")
    val dateExpires: String,
    @ColumnInfo(name = "date_expires_gmt")
    val dateExpiresGmt: String,
    @ColumnInfo(name = "usage_count")
    val usageCount: Int,
    @ColumnInfo(name = "individual_use")
    val individualUse: Boolean,
    @ColumnInfo(name = "product_ids")
    val productIds: List<Int>,
    @ColumnInfo(name = "excluded_product_ids")
    val excludedProductIds: List<Int>,
    @ColumnInfo(name = "usage_limit")
    val usageLimit: Int,
    @ColumnInfo(name = "usage_limit_per_user")
    val usageLimitPerUser: Int,
    @ColumnInfo(name = "limit_usage_to_x_items")
    val limitUsageToXItems: Int,
    @ColumnInfo(name = "free_shipping")
    val freeShipping: Boolean,
    @ColumnInfo(name = "product_categories")
    val productCategories: List<CategoryEntity>,
    @ColumnInfo(name = "exclude_sale_items")
    val excludeSaleItems: Boolean,
    @ColumnInfo(name = "maximum_amount")
    val maximumAmount: String,
    @ColumnInfo(name = "minimum_amount")
    val minimumAmount: String,
    @ColumnInfo(name = "email_restrictions")
    val emailRestrictions: List<String>
)