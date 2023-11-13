/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/3/23, 11:45 PM
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

@Entity(tableName = CacheConstants.PRODUCTS_TABLE)
data class ProductsResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    val name: String?,
    val slug: String?,
    @ColumnInfo(name = "date_created")
    val dateCreated: String?,
    val type: String?,
    val status: String?,
    val featured: Boolean?,
    @ColumnInfo(name = "catalog_visibility")
    val catalogVisibility: String?,
    val description: String?,
    @ColumnInfo(name = "short_description")
    val shortDescription: String?,
    val sku: String?,
    val price: String?,
    @ColumnInfo(name = "regular_price")
    val regularPrice: String?,
    @ColumnInfo(name = "sale_price")
    val salePrice: String?,
    @ColumnInfo(name = "date_on_sale_from")
    val dateOnSaleFrom: String?,
    @ColumnInfo(name = "date_on_sale_to")
    val dateOnSaleTo: String?,
    @ColumnInfo(name = "on_sale")
    val onSale: Boolean?,
    val purchasable: Boolean?,
    @ColumnInfo(name = "total_sales")
    val totalSales: Int?,
    @ColumnInfo(name = "tax_status")
    val taxStatus: String?,
    @ColumnInfo(name = "tax_class")
    val taxClass: String?,
    @ColumnInfo(name = "manage_stock")
    val manageStock: Boolean?,
    @ColumnInfo(name = "stock_quantity")
    val stockQuantity: Int?,
    @ColumnInfo(name = "sold_individually")
    val soldIndividually: Boolean?,
    @ColumnInfo(name = "shipping_required")
    val shippingRequired: Boolean?,
    @ColumnInfo(name = "shipping_taxable")
    val shippingTaxable: Boolean?,
    @ColumnInfo(name = "shipping_class")
    val shippingClass: String?,
    @ColumnInfo(name = "shipping_class_id")
    val shippingClassId: Int?,
    @ColumnInfo(name = "reviews_allowed")
    val reviewsAllowed: Boolean?,
    @ColumnInfo(name = "average_rating")
    val averageRating: String?,
    @ColumnInfo(name = "rating_count")
    val ratingCount: Int?,
    val categories: List<CategoryEntity>?,
    val tags: List<TagEntity>?,
    val images: List<ImageEntity>?,
    val attributes: List<AttributeEntity>?,
    @ColumnInfo(name = "default_attributes")
    val defaultAttributes: List<DefaultAttributeEntity>?,
    @ColumnInfo(name = "stock_status")
    val stockStatus: String?,
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean?,
    @ColumnInfo("downloaded")
    val downloaded: Boolean?
)