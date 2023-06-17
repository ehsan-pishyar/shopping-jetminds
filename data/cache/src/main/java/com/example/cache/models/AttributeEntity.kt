package com.example.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.ATTRS_TABLE)
data class AttributeEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val options: List<String>,
    val position: Int,
    val variation: Boolean,
    val visible: Boolean
)