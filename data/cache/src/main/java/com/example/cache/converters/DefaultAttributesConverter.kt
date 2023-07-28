package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.DefaultAttributeEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DefaultAttributesConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(defaultAttrsEntity: List<DefaultAttributeEntity>?): String?{
        if (defaultAttrsEntity.isNullOrEmpty()) return null

        val type = object : TypeToken<List<DefaultAttributeEntity>?>() {}.type
        return gson.toJson(defaultAttrsEntity, type)
    }

    @TypeConverter
    fun to(defaultAttrItem: String?): List<DefaultAttributeEntity>?{
        if (defaultAttrItem.isNullOrEmpty()) return null

        val type = object : TypeToken<List<DefaultAttributeEntity>?>() {}.type
        return gson.fromJson(defaultAttrItem, type)
    }
}