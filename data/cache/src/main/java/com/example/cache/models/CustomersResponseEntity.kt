/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/29/23, 11:20 PM
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

@Entity(tableName = CacheConstants.CUSTOMERS_TABLE)
data class CustomersResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    @ColumnInfo(name = "date_created")
    val dateCreated: String?,
    @ColumnInfo(name = "date_created_gmt")
    val dateCreatedGmt: String?,
    val email: String?,
    @ColumnInfo(name = "first_name")
    val firstName: String?,
    @ColumnInfo(name = "last_name")
    val lastName: String?,
    val role: String?,
    val username: String?,
    val billing: BillingEntity?,
    val shipping: ShippingEntity?,
    @ColumnInfo(name = "is_paying_customer")
    val isPayingCustomer: Boolean?,
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String?
)