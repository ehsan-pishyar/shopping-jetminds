package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.PRODUCT_CATEGORIES_TABLE)
data class ProductCategoriesResponseEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "slug")
    val slug: String,
    @ColumnInfo(name = "parent")
    val parent: Int,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "display")
    val display: String,
    @ColumnInfo(name = "image")
    val image: ImageEntity,
    @ColumnInfo(name = "menu_order")
    val menuOrder: Int,
    @ColumnInfo(name = "count")
    val count: Int,
)