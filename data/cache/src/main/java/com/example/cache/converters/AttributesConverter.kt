package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.AttributeEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AttributesConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(attrEntity: List<AttributeEntity>?): String?{
        if (attrEntity.isNullOrEmpty()) return null

        val type = object : TypeToken<List<AttributeEntity>?>() {}.type
        return gson.toJson(attrEntity, type)
    }

    @TypeConverter
    fun to(attrItem: String?): List<AttributeEntity>?{
        if (attrItem.isNullOrEmpty()) return null

        val type = object : TypeToken<List<AttributeEntity>?>() {}.type
        return gson.fromJson(attrItem, type)
    }
}