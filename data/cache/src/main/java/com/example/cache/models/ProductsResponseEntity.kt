package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.PRODUCTS_TABLE)
data class ProductsResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    val name: String? = null,
    val slug: String? = null,
    @ColumnInfo(name = "date_created")
    val dateCreated: String? = null,
    val type: String? = null,
    val status: String? = null,
    val featured: Boolean? = null,
    @ColumnInfo(name = "catalog_visibility")
    val catalogVisibility: String? = null,
    val description: String? = null,
    @ColumnInfo(name = "short_description")
    val shortDescription: String? = null,
    val sku: String? = null,
    val price: String? = null,
    @ColumnInfo(name = "regular_price")
    val regularPrice: String? = null,
    @ColumnInfo(name = "sale_price")
    val salePrice: String? = null,
    @ColumnInfo(name = "date_on_sale_from")
    val dateOnSaleFrom: String? = null,
    @ColumnInfo(name = "date_on_sale_to")
    val dateOnSaleTo: String? = null,
    @ColumnInfo(name = "on_sale")
    val onSale: Boolean? = null,
    val purchasable: Boolean? = null,
    @ColumnInfo(name = "total_sales")
    val totalSales: Int? = null,
    @ColumnInfo(name = "tax_status")
    val taxStatus: String? = null,
    @ColumnInfo(name = "tax_class")
    val taxClass: String? = null,
    @ColumnInfo(name = "manage_stock")
    val manageStock: Boolean? = null,
    @ColumnInfo(name = "stock_quantity")
    val stockQuantity: Int? = null,
    @ColumnInfo(name = "sold_individually")
    val soldIndividually: Boolean? = null,
    @ColumnInfo(name = "shipping_required")
    val shippingRequired: Boolean? = null,
    @ColumnInfo(name = "shipping_taxable")
    val shippingTaxable: Boolean? = null,
    @ColumnInfo(name = "shipping_class")
    val shippingClass: String? = null,
    @ColumnInfo(name = "shipping_class_id")
    val shippingClassId: Int? = null,
    @ColumnInfo(name = "reviews_allowed")
    val reviewsAllowed: Boolean? = null,
    @ColumnInfo(name = "average_rating")
    val averageRating: String? = null,
    @ColumnInfo(name = "rating_count")
    val ratingCount: Int? = null,
    val categories: List<CategoryEntity>? = null,
    val tags: List<TagEntity>? = null,
    val images: List<ImageEntity>? = null,
    val attributes: List<AttributeEntity>? = null,
    @ColumnInfo(name = "default_attributes")
    val defaultAttributes: List<DefaultAttributeEntity>? = null,
    @ColumnInfo(name = "stock_status")
    val stockStatus: String? = null
)