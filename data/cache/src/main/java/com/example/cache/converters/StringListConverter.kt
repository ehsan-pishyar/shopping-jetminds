package com.example.cache.converters

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class StringListConverter {

    @TypeConverter
    fun fromStringList(list: List<String>?): String? {
        if (list == null) return null
        return Json.encodeToString(list)
    }

    @TypeConverter
    fun toStringList(item: String?): List<String>? {
        if (item == null) return null
        return Json.decodeFromString(item)
    }
}