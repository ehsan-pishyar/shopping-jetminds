/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/29/23, 10:23 PM
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