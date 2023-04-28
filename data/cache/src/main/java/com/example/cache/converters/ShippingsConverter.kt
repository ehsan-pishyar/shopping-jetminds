package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ShippingEntity
import com.squareup.moshi.Moshi

class ShippingsConverter {

    private val moshi = Moshi.Builder().build()
    @TypeConverter
    fun toJson(shippingsEntity: ShippingEntity?): String? {
        return shippingsEntity?.let {
            moshi.adapter(ShippingEntity::class.java).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(value: String?): ShippingEntity? {
        return value?.let {
            moshi.adapter(ShippingEntity::class.java).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromShipping(shippingEntity: ShippingEntity?): String? {
//        if (shippingEntity == null) return null
//        return Json.encodeToString(shippingEntity)
//    }
//
//    @TypeConverter
//    fun toShipping(shippingItem: String?): ShippingEntity? {
//        if (shippingItem == null) return null
//        return Json.decodeFromString(shippingItem)
//    }
}