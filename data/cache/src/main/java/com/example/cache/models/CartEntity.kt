package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants.CART_TABLE

@Entity(tableName = CART_TABLE)
data class CartEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cart_id")
    val cartId: Int?,
    val count: Int?,
    val items: List<ProductsResponseEntity>?
)