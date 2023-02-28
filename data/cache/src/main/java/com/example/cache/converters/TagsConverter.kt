package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ImageEntity
import com.example.cache.models.TagEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class TagsConverter {

    @TypeConverter
    fun fromTags(tags: List<TagEntity>?): String? {
        if (tags == null) return null
        return Json.encodeToString(tags)
    }

    @TypeConverter
    fun toTags(tagsItem: String?): List<TagEntity>? {
        if (tagsItem == null) return null
        return Json.decodeFromString(tagsItem)
    }
}