package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ShippingEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ShippingsConverter {

    @TypeConverter
    fun fromShipping(shippingEntity: ShippingEntity?): String? {
        if (shippingEntity == null) return null
        return Json.encodeToString(shippingEntity)
    }

    @TypeConverter
    fun toShipping(shippingItem: String?): ShippingEntity? {
        if (shippingItem == null) return null
        return Json.decodeFromString(shippingItem)
    }
}