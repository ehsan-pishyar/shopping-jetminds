package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.AttributeEntity
import com.example.cache.models.ImageEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class AttributesConverter {

    @TypeConverter
    fun fromAttributes(attributeEntity: List<AttributeEntity>?): String? {
        if (attributeEntity == null) return null
        return Json.encodeToString(attributeEntity)
    }

    @TypeConverter
    fun toAttributes(attributesItem: String?): List<AttributeEntity>? {
        if (attributesItem == null) return null
        return Json.decodeFromString(attributesItem)
    }
}