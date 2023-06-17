package com.example.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.IMAGES_TABLE)
data class ImageEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val src: String,
    val alt: String
)