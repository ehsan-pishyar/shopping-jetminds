package com.example.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.TAGS_TABLE)
data class TagEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String
)
