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

data class OrdersResponseDto(
    val id: Int?,
    @SerializedName("parent_id")
    val parentId: Int?,
    val status: String?,
    val currency: String?,
    @SerializedName("prices_include_tax")
    val pricesIncludeTax: Boolean?,
    @SerializedName("date_created")
    val dateCreated: String?,
    @SerializedName("date_modified")
    val dateModified: String?,
    @SerializedName("discount_total")
    val discountTotal: String?,
    @SerializedName("discount_tax")
    val discountTax: String?,
    @SerializedName("shipping_total")
    val shippingTotal: String?,
    @SerializedName("shipping_tax")
    val shippingTax: String?,
    @SerializedName("cart_tax")
    val cartTax: String?,
    val total: String?,
    @SerializedName("total_tax")
    val totalTax: String?,
    @SerializedName("customer_id")
    val customerId: Int?,
    @SerializedName("order_key")
    val orderKey: String?,
    @SerializedName("billing")
    val billing: BillingDto?,
    @SerializedName("shipping")
    val shipping: ShippingDto?,
    @SerializedName("payment_method")
    val paymentMethod: String?,
    @SerializedName("payment_method_title")
    val paymentMethodTitle: String?,
    @SerializedName("transaction_id")
    val transactionId: String?,
    @SerializedName("customer_ip_address")
    val customerIpAddress: String?,
    @SerializedName("customer_note")
    val customerNote: String?,
    @SerializedName("date_completed")
    val dateCompleted: String?,
    @SerializedName("date_paid")
    val datePaid: String?,
    @SerializedName("cart_hash")
    val cartHash: String?,
    val number: String?,
    @SerializedName("line_items")
    val lineItems: List<LineItemDto>?,
    @SerializedName("tax_lines")
    val taxLines: List<TaxLineDto>?,
    @SerializedName("shipping_lines")
    val shippingLines: List<ShippingLineDto>?,
    @SerializedName("payment_url")
    val paymentUrl: String?,
    @SerializedName("date_created_gmt")
    val dateCreatedGmt: String?,
    @SerializedName("date_modified_gmt")
    val dateModifiedGmt: String?,
    @SerializedName("date_completed_gmt")
    val dateCompletedGmt: String?,
    @SerializedName("date_paid_gmt")
    val datePaidGmt: String?,
    @SerializedName("currency_symbol")
    val currencySymbol: String?
)