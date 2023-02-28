package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.LineItemEntity
import com.example.cache.models.ShippingEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class LineItemsConverter {

    @TypeConverter
    fun fromLineItems(lineItems: List<LineItemEntity>?): String? {
        if (lineItems == null) return null
        return Json.encodeToString(lineItems)
    }

    @TypeConverter
    fun toLineItems(lineItemsString: String?): List<LineItemEntity>? {
        if (lineItemsString == null) return null
        return Json.decodeFromString(lineItemsString)
    }
}