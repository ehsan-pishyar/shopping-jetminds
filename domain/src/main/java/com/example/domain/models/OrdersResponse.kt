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

data class OrdersResponse(
    val id: Int?,
    val parentId: Int?,
    val status: String?,
    val currency: String?,
    val pricesIncludeTax: Boolean?,
    val dateCreated: String?,
    val dateModified: String?,
    val discountTotal: String?,
    val discountTax: String?,
    val shippingTotal: String?,
    val shippingTax: String?,
    val cartTax: String?,
    val total: String?,
    val totalTax: String?,
    val customerId: Int?,
    val orderKey: String?,
    val billing: Billing?,
    val shipping: Shipping?,
    val paymentMethod: String?,
    val paymentMethodTitle: String?,
    val transactionId: String?,
    val customerIpAddress: String?,
    val customerNote: String?,
    val dateCompleted: String?,
    val datePaid: String?,
    val cartHash: String?,
    val number: String?,
    val lineItems: List<LineItem>?,
    val taxLines: List<TaxLine>?,
    val shippingLines: List<ShippingLine>?,
    val paymentUrl: String?,
    val dateCreatedGmt: String?,
    val dateModifiedGmt: String?,
    val dateCompletedGmt: String?,
    val datePaidGmt: String?,
    val currencySymbol: String?
)