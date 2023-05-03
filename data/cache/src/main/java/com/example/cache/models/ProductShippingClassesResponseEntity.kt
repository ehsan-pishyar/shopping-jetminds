package com.example.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants
import kotlinx.serialization.Serializable

@Entity(tableName = CacheConstants.PRODUCT_SHIPPING_CLASSES_TABLE)
data class ProductShippingClassesResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val slug: String,
    val description: String,
    val count: Int
)