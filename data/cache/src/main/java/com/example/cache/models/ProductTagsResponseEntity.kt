package com.example.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants
import kotlinx.serialization.Serializable

@Entity(tableName = CacheConstants.PRODUCT_TAGS_TABLE)
data class ProductTagsResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val slug: String,
    val description: String,
    val count: Int
)