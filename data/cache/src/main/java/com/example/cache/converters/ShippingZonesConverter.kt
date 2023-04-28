package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ShippingZonesResponseEntity
import com.squareup.moshi.Moshi

class ShippingZonesConverter {

    private val moshi = Moshi.Builder().build()
    @TypeConverter
    fun toJson(shippingZoneEntity: ShippingZonesResponseEntity?): String? {
        return shippingZoneEntity?.let {
            moshi.adapter(ShippingZonesResponseEntity::class.java).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(value: String?): ShippingZonesResponseEntity? {
        return value?.let {
            moshi.adapter(ShippingZonesResponseEntity::class.java).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromShippingZones(shippingZones: ShippingZonesResponseEntity?): String? {
//        if (shippingZones == null) return null
//        return Json.encodeToString(shippingZones)
//    }
//
//    @TypeConverter
//    fun toShippingZones(shippingZonesString: String?): ShippingZonesResponseEntity? {
//        if (shippingZonesString.isNullOrEmpty()) return null
//        return Json.decodeFromString(shippingZonesString)
//    }
}