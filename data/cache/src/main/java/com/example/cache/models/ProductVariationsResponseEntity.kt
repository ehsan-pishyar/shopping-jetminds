package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.PRODUCT_VARIATIONS_TABLE)
data class ProductVariationsResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    @ColumnInfo(name = "date_created")
    val dateCreated: String? = null,
    @ColumnInfo(name = "date_created_gmt")
    val dateCreatedGmt: String? = null,
    val description: String? = null,
    val permalink: String? = null,
    val sku: String? = null,
    val price: String? = null,
    @ColumnInfo(name = "regular_price")
    val regularPrice: String? = null,
    @ColumnInfo(name = "sale_price")
    val salePrice: String? = null,
    @ColumnInfo(name = "date_on_sale_from")
    val dateOnSaleFrom: String? = null,
    @ColumnInfo(name = "date_on_sale_from_gmt")
    val dateOnSaleFromGmt: String? = null,
    @ColumnInfo(name = "date_on_sale_to")
    val dateOnSaleTo: String? = null,
    @ColumnInfo(name = "date_on_sale_to_gmt")
    val dateOnSaleToGmt: String? = null,
    @ColumnInfo(name = "on_sale")
    val onSale: Boolean? = null,
    val status: String? = null,
    val purchasable: Boolean? = null,
    @ColumnInfo(name = "tax_status")
    val taxStatus: String? = null,
    @ColumnInfo(name = "tax_class")
    val taxClass: String? = null,
    @ColumnInfo(name = "manage_stock")
    val manageStock: Boolean? = null,
    @ColumnInfo(name = "stock_quantity")
    val stockQuantity: Int? = null,
    @ColumnInfo(name = "stock_status")
    val stockStatus: String? = null,
    @ColumnInfo(name = "shipping_class")
    val shippingClass: String? = null,
    @ColumnInfo(name = "shipping_class_id")
    val shippingClassId: Int? = null,
    val image: ImageEntity? = null,
    val attributes: List<AttributeEntity>? = null
)