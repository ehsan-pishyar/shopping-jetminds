package com.example.cache.converters

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PrimitiveTypesConverter {

    @TypeConverter
    fun fromStrings(stringList: List<String>?): String? {
        if (stringList.isNullOrEmpty()) return null
        return Json.encodeToString(stringList)
    }

    @TypeConverter
    fun toStrings(stringsItem: String?): List<String>? {
        if (stringsItem == null) return null
        return Json.decodeFromString(stringsItem)
    }

    @TypeConverter
    fun fromInts(intList: List<Int>?): String? {
        if (intList.isNullOrEmpty()) return null
        return Json.encodeToString(intList)
    }

    @TypeConverter
    fun toInts(intListItem: String?): List<Int>? {
        if (intListItem == null) return null
        return Json.decodeFromString(intListItem)
    }
}