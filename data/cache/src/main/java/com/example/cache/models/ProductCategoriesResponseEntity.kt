package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants
import kotlinx.serialization.Serializable

@Entity(tableName = CacheConstants.PRODUCT_CATEGORIES_TABLE)
data class ProductCategoriesResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    var name: String,
    val slug: String,
    val parent: Int,
    val description: String,
    val display: String,
    val image: ImageEntity,
    @ColumnInfo(name = "menu_order")
    val menuOrder: Int,
    val count: Int,
)