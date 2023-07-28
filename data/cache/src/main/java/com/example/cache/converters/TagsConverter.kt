package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.TagEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TagsConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(tagsEntity: List<TagEntity>?): String?{
        if (tagsEntity.isNullOrEmpty()) return null

        val type = object : TypeToken<List<TagEntity>?>() {}.type
        return gson.toJson(tagsEntity, type)
    }

    @TypeConverter
    fun to(tagsItem: String?): List<TagEntity>?{
        if (tagsItem.isNullOrEmpty()) return null

        val type = object : TypeToken<List<TagEntity>?>() {}.type
        return gson.fromJson(tagsItem, type)
    }
}