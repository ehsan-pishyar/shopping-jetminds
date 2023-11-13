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

@Entity(tableName = CacheConstants.PRODUCT_VARIATIONS_TABLE)
data class ProductVariationsResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int?,
    @ColumnInfo(name = "date_created")
    val dateCreated: String?,
    @ColumnInfo(name = "date_created_gmt")
    val dateCreatedGmt: String?,
    val description: String?,
    val permalink: String?,
    val sku: String?,
    val price: String?,
    @ColumnInfo(name = "regular_price")
    val regularPrice: String?,
    @ColumnInfo(name = "sale_price")
    val salePrice: String?,
    @ColumnInfo(name = "date_on_sale_from")
    val dateOnSaleFrom: String?,
    @ColumnInfo(name = "date_on_sale_from_gmt")
    val dateOnSaleFromGmt: String?,
    @ColumnInfo(name = "date_on_sale_to")
    val dateOnSaleTo: String?,
    @ColumnInfo(name = "date_on_sale_to_gmt")
    val dateOnSaleToGmt: String?,
    @ColumnInfo(name = "on_sale")
    val onSale: Boolean?,
    val status: String?,
    val purchasable: Boolean?,
    @ColumnInfo(name = "tax_status")
    val taxStatus: String?,
    @ColumnInfo(name = "tax_class")
    val taxClass: String?,
    @ColumnInfo(name = "manage_stock")
    val manageStock: Boolean?,
    @ColumnInfo(name = "stock_quantity")
    val stockQuantity: Int?,
    @ColumnInfo(name = "stock_status")
    val stockStatus: String?,
    @ColumnInfo(name = "shipping_class")
    val shippingClass: String?,
    @ColumnInfo(name = "shipping_class_id")
    val shippingClassId: Int?,
    val image: ImageEntity?,
    val attributes: List<AttributeEntity>?
)