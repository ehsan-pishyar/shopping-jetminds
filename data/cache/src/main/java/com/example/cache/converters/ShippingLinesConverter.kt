package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ShippingLineEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ShippingLinesConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(shippingLinesEntity: List<ShippingLineEntity>?): String?{
        if (shippingLinesEntity.isNullOrEmpty()) return null

        val type = object : TypeToken<List<ShippingLineEntity>?>() {}.type
        return gson.toJson(shippingLinesEntity, type)
    }

    @TypeConverter
    fun to(shippingLinesItem: String?): List<ShippingLineEntity>?{
        if (shippingLinesItem.isNullOrEmpty()) return null

        val type = object : TypeToken<List<ShippingLineEntity>?>() {}.type
        return gson.fromJson(shippingLinesItem, type)
    }
}