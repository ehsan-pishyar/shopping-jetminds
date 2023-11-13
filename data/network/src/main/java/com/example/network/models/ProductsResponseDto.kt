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

data class ProductsResponseDto(
    val id: Int?,
    val name: String?,
    val slug: String?,
    @SerializedName("date_created")
    val dateCreated: String?,
    val type: String?,
    val status: String?,
    val featured: Boolean?,
    @SerializedName("catalog_visibility")
    val catalogVisibility: String?,
    val description: String?,
    @SerializedName("short_description")
    val shortDescription: String?,
    val sku: String?,
    val price: String?,
    @SerializedName("regular_price")
    val regularPrice: String?,
    @SerializedName("sale_price")
    val salePrice: String?,
    @SerializedName("date_on_sale_from")
    val dateOnSaleFrom: String?,
    @SerializedName("date_on_sale_to")
    val dateOnSaleTo: String?,
    @SerializedName("on_sale")
    val onSale: Boolean?,
    val purchasable: Boolean?,
    @SerializedName("total_sales")
    val totalSales: Int?,
    @SerializedName("tax_status")
    val taxStatus: String?,
    @SerializedName("tax_class")
    val taxClass: String?,
    @SerializedName("manage_stock")
    val manageStock: Boolean?,
    @SerializedName("stock_quantity")
    val stockQuantity: Int?,
    @SerializedName("sold_individually")
    val soldIndividually: Boolean?,
    @SerializedName("shipping_required")
    val shippingRequired: Boolean?,
    @SerializedName("shipping_taxable")
    val shippingTaxable: Boolean?,
    @SerializedName("shipping_class")
    val shippingClass: String?,
    @SerializedName("shipping_class_id")
    val shippingClassId: Int?,
    @SerializedName("reviews_allowed")
    val reviewsAllowed: Boolean?,
    @SerializedName("average_rating")
    val averageRating: String?,
    @SerializedName("rating_count")
    val ratingCount: Int?,
    val categories: List<CategoryDto>?,
    val tags: List<TagDto>?,
    val images: List<ImageDto>?,
    val attributes: List<AttributeDto>?,
    @SerializedName("default_attributes")
    val defaultAttributes: List<DefaultAttributeDto>?,
    @SerializedName("stock_status")
    val stockStatus: String?
)