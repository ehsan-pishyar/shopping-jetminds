package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ShippingEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ShippingsConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(shippingEntity: ShippingEntity?): String?{
        if (shippingEntity == null) return null

        val type = object : TypeToken<ShippingEntity?>() {}.type
        return gson.toJson(shippingEntity, type)
    }

    @TypeConverter
    fun to(shippingItem: String?): ShippingEntity?{
        if (shippingItem.isNullOrEmpty()) return null

        val type = object : TypeToken<ShippingEntity?>() {}.type
        return gson.fromJson(shippingItem, type)
    }
}