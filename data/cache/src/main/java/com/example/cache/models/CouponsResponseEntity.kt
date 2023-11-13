/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/29/23, 11:18 PM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.COUPONS_TABLE)
data class CouponsResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    val code: String?,
    val amount: String?,
    val status: String?,
    @ColumnInfo(name = "date_created")
    val dateCreated: String?,
    @ColumnInfo(name = "date_created_gmt")
    val dateCreatedGmt: String?,
    @ColumnInfo(name = "discount_type")
    val discountType: String?,
    val description: String?,
    @ColumnInfo(name = "date_expires")
    val dateExpires: String?,
    @ColumnInfo(name = "date_expires_gmt")
    val dateExpiresGmt: String?,
    @ColumnInfo(name = "usage_count")
    val usageCount: Int?,
    @ColumnInfo(name = "individual_use")
    val individualUse: Boolean?,
    @ColumnInfo(name = "product_ids")
    val productIds: List<Int>?,
    @ColumnInfo(name = "excluded_product_ids")
    val excludedProductIds: List<Int>?,
    @ColumnInfo(name = "usage_limit")
    val usageLimit: Int?,
    @ColumnInfo(name = "usage_limit_per_user")
    val usageLimitPerUser: Int?,
    @ColumnInfo(name = "limit_usage_to_x_items")
    val limitUsageToXItems: Int?,
    @ColumnInfo(name = "free_shipping")
    val freeShipping: Boolean?,
    @ColumnInfo(name = "product_categories")
    val productCategories: List<CategoryEntity>?,
    @ColumnInfo(name = "exclude_sale_items")
    val excludeSaleItems: Boolean?,
    @ColumnInfo(name = "maximum_amount")
    val maximumAmount: String?,
    @ColumnInfo(name = "minimum_amount")
    val minimumAmount: String?,
    @ColumnInfo(name = "email_restrictions")
    val emailRestrictions: List<String>?
)