package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.TaxEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class TaxesConverter {

    @TypeConverter
    fun fromLineItems(taxes: List<TaxEntity>?): String? {
        if (taxes == null) return null
        return Json.encodeToString(taxes)
    }

    @TypeConverter
    fun toLineItems(taxesString: String?): List<TaxEntity>? {
        if (taxesString == null) return null
        return Json.decodeFromString(taxesString)
    }
}