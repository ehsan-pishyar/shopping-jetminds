package com.example.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.PRODUCT_SHIPPING_CLASSES_TABLE)
data class ProductShippingClassesResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    val name: String? = null,
    val slug: String? = null,
    val description: String? = null,
    val count: Int? = null
)