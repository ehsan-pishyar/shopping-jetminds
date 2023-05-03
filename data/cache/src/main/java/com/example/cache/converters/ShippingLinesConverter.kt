package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ShippingLineEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ShippingLinesConverter {

    @TypeConverter
    fun fromShippingLines(shippingLines: List<ShippingLineEntity>?): String? {
        if (shippingLines == null) return null
        return Json.encodeToString(shippingLines)
    }

    @TypeConverter
    fun toShippingLine(shippingLinesString: String?): List<ShippingLineEntity>? {
        if (shippingLinesString == null) return null
        return Json.decodeFromString(shippingLinesString)
    }
}