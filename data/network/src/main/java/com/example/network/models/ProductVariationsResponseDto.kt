/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/29/23, 10:24 PM
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

data class ProductVariationsResponseDto(
    val id: Int?,
    @SerializedName("date_created")
    val dateCreated: String?,
    @SerializedName("date_created_gmt")
    val dateCreatedGmt: String?,
    val description: String?,
    val permalink: String?,
    val sku: String?,
    val price: String?,
    @SerializedName("regular_price")
    val regularPrice: String?,
    @SerializedName("sale_price")
    val salePrice: String?,
    @SerializedName("date_on_sale_from")
    val dateOnSaleFrom: String?,
    @SerializedName("date_on_sale_from_gmt")
    val dateOnSaleFromGmt: String?,
    @SerializedName("date_on_sale_to")
    val dateOnSaleTo: String?,
    @SerializedName("date_on_sale_to_gmt")
    val dateOnSaleToGmt: String?,
    @SerializedName("on_sale")
    val onSale: Boolean?,
    val status: String?,
    val purchasable: Boolean?,
    @SerializedName("tax_status")
    val taxStatus: String?,
    @SerializedName("tax_class")
    val taxClass: String?,
    @SerializedName("manage_stock")
    val manageStock: Boolean?,
    @SerializedName("stock_quantity")
    val stockQuantity: Int?,
    @SerializedName("stock_status")
    val stockStatus: String?,
    @SerializedName("shipping_class")
    val shippingClass: String?,
    @SerializedName("shipping_class_id")
    val shippingClassId: Int?,
    val image: ImageDto?,
    val attribute: List<AttributeDto>?
)