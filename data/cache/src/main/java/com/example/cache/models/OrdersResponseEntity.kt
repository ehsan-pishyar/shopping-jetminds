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

@Entity(tableName = CacheConstants.ORDERS_TABLE)
data class OrdersResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    @ColumnInfo(name = "parent_id")
    val parentId: Int?,
    val status: String?,
    val currency: String?,
    @ColumnInfo(name = "prices_include_tax")
    val pricesIncludeTax: Boolean?,
    @ColumnInfo(name = "date_created")
    val dateCreated: String?,
    @ColumnInfo(name = "date_modified")
    val dateModified: String?,
    @ColumnInfo(name = "discount_total")
    val discountTotal: String?,
    @ColumnInfo(name = "discount_tax")
    val discountTax: String?,
    @ColumnInfo(name = "shipping_total")
    val shippingTotal: String?,
    @ColumnInfo(name = "shipping_tax")
    val shippingTax: String?,
    @ColumnInfo(name = "cart_tax")
    val cartTax: String?,
    val total: String?,
    @ColumnInfo(name = "total_tax")
    val totalTax: String?,
    @ColumnInfo(name = "customer_id")
    val customerId: Int?,
    @ColumnInfo(name = "order_key")
    val orderKey: String?,
    val billing: BillingEntity?,
    val shipping: ShippingEntity?,
    @ColumnInfo(name = "payment_method")
    val paymentMethod: String?,
    @ColumnInfo(name = "payment_method_title")
    val paymentMethodTitle: String?,
    @ColumnInfo(name = "transaction_id")
    val transactionId: String?,
    @ColumnInfo(name = "customer_ip_address")
    val customerIpAddress: String?,
    @ColumnInfo(name = "customer_note")
    val customerNote: String?,
    @ColumnInfo(name = "date_completed")
    val dateCompleted: String?,
    @ColumnInfo(name = "date_paid")
    val datePaid: String?,
    @ColumnInfo(name = "cart_hash")
    val cartHash: String?,
    val number: String?,
    @ColumnInfo(name = "line_items")
    val lineItems: List<LineItemEntity>?,
    @ColumnInfo(name = "tax_lines")
    val taxLines: List<TaxLineEntity>?,
    @ColumnInfo(name = "shipping_lines")
    val shippingLines: List<ShippingLineEntity>?,
    @ColumnInfo(name = "payment_url")
    val paymentUrl: String?,
    @ColumnInfo(name = "date_created_gmt")
    val dateCreatedGmt: String?,
    @ColumnInfo(name = "date_modified_gmt")
    val dateModifiedGmt: String?,
    @ColumnInfo(name = "date_completed_gmt")
    val dateCompletedGmt: String?,
    @ColumnInfo(name = "date_paid_gmt")
    val datePaidGmt: String?,
    @ColumnInfo(name = "currency_symbol")
    val currencySymbol: String?
)