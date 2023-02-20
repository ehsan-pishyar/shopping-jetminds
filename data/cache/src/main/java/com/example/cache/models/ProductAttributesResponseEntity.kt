package com.example.cache.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.PRODUCT_ATTRS_TABLE)
data class ProductAttributesResponseEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val slug: String,
    val type: String,
    @ColumnInfo(name = "order_by")
    val orderBy: String,
    @ColumnInfo(name = "has_archives")
    val hasArchives: Boolean
)