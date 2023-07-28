package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.LineItemEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LineItemsConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(lineItemsEntity: List<LineItemEntity>?): String?{
        if (lineItemsEntity.isNullOrEmpty()) return null

        val type = object : TypeToken<List<LineItemEntity>?>() {}.type
        return gson.toJson(lineItemsEntity, type)
    }

    @TypeConverter
    fun to(lineItemsItem: String?): List<LineItemEntity>?{
        if (lineItemsItem.isNullOrEmpty()) return null

        val type = object : TypeToken<List<LineItemEntity>?>() {}.type
        return gson.fromJson(lineItemsItem, type)
    }
}