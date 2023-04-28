package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.PRODUCT_CATEGORIES_TABLE)
data class ProductCategoriesResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    var name: String? = null,
    val slug: String? = null,
    val parent: Int? = null,
    val description: String? = null,
    val display: String? = null,
    val image: ImageEntity? = null,
    @ColumnInfo(name = "menu_order")
    val menuOrder: Int? = null,
    val count: Int? = null,
)