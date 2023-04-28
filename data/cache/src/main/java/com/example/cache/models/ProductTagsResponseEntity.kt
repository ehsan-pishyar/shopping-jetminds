package com.example.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.PRODUCT_TAGS_TABLE)
data class ProductTagsResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int? = null,
    val name: String? = null,
    val slug: String? = null,
    val description: String? = null,
    val count: Int? = null
)