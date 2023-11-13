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

data class LineItemDto(
    val id: Int?,
    val name: String?,
    val price: Int?,
    @SerializedName("product_id")
    val productId: Int?,
    val quantity: Int?,
    val sku: String?,
    val subtotal: String?,
    @SerializedName("subtotal_tax")
    val subtotalTax: String?,
    @SerializedName("tax_class")
    val taxClass: String?,
    val taxes: List<TaxDto>?,
    val total: String?,
    @SerializedName("total_tax")
    val totalTax: String?,
    @SerializedName("variation_id")
    val variationId: Int?
)