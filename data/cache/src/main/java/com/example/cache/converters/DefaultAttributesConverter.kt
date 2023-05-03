package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.DefaultAttributeEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class DefaultAttributesConverter {

    @TypeConverter
    fun fromDefaultAttributes(defaultAttributeEntity: List<DefaultAttributeEntity>?): String? {
        if (defaultAttributeEntity == null) return null
        return Json.encodeToString(defaultAttributeEntity)
    }

    @TypeConverter
    fun toDefaultAttributes(defaultAttributeEntityItems: String?): List<DefaultAttributeEntity>? {
        if (defaultAttributeEntityItems == null) return null
        return Json.decodeFromString(defaultAttributeEntityItems)
    }
}