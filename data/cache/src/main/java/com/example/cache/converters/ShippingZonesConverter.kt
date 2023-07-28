package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ShippingZonesResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ShippingZonesConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(shippingZoneEntity: ShippingZonesResponseEntity?): String?{
        if (shippingZoneEntity== null) return null

        val type = object : TypeToken<ShippingZonesResponseEntity?>() {}.type
        return gson.toJson(shippingZoneEntity, type)
    }

    @TypeConverter
    fun to(shippingZoneItem: String?): ShippingZonesResponseEntity?{
        if (shippingZoneItem.isNullOrEmpty()) return null

        val type = object : TypeToken<ShippingZonesResponseEntity?>() {}.type
        return gson.fromJson(shippingZoneItem, type)
    }
}