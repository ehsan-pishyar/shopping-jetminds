/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/5/23, 12:19 AM
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

data class CustomersResponseDto(
    val id: Int?,
    @SerializedName("date_created")
    val dateCreated: String?,
    @SerializedName("date_created_gmt")
    val dateCreatedGmt: String?,
    val email: String?,
    @SerializedName("first_name")
    val firstName: String?,
    @SerializedName("last_name")
    val lastName: String?,
    val role: String?,
    val username: String?,
    @SerializedName("billing")
    val billing: BillingDto?,
    @SerializedName("shipping")
    val shipping: ShippingDto?,
    @SerializedName("is_paying_customer")
    val isPayingCustomer: Boolean?,
    @SerializedName("avatar_url")
    val avatarUrl: String?
)