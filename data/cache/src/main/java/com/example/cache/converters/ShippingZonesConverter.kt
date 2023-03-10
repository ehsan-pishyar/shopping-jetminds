package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ShippingZonesResponseEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ShippingZonesConverter {

    @TypeConverter
    fun fromShippingZones(shippingZones: ShippingZonesResponseEntity?): String? {
        if (shippingZones == null) return null
        return Json.encodeToString(shippingZones)
    }

    @TypeConverter
    fun toShippingZones(shippingZonesString: String?): ShippingZonesResponseEntity? {
        if (shippingZonesString.isNullOrEmpty()) return null
        return Json.decodeFromString(shippingZonesString)
    }
}