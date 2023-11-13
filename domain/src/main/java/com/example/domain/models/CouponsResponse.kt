/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/29/23, 10:35 PM
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