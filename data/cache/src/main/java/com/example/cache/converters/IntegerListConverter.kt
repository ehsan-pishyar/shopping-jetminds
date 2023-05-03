package com.example.cache.converters

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


class IntegerListConverter {
    @TypeConverter
    fun fromIntegerList(list: List<Int>?): String? {
        if (list == null) return null
        return Json.encodeToString(list)
    }

    @TypeConverter
    fun toIntegerList(item: String?): List<Int>? {
        if (item == null) return null
        return Json.decodeFromString(item)
    }
}