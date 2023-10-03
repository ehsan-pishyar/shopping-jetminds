package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants.CART_TABLE

@Entity(tableName = CART_TABLE)
data class CartEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "product_id")
    val productId: Int?,
    @ColumnInfo(name = "product_title")
    val productTitle: String?,
    @ColumnInfo(name = "product_image")
    val productImage: String?,
    @ColumnInfo(name = "product_category")
    val productCategory: String?,
    @ColumnInfo(name = "product_price")
    val productPrice: Int?,
    @ColumnInfo(name = "date_added")
    val dateAdded: String?,
    @ColumnInfo(name = "item_count")
    val itemCount: Int?

)