package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ImageEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ImageConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(imageEntity: ImageEntity?): String?{
        if (imageEntity == null) return null

        val type = object : TypeToken<ImageEntity?>() {}.type
        return gson.toJson(imageEntity, type)
    }

    @TypeConverter
    fun to(imageItem: String?): ImageEntity?{
        if (imageItem.isNullOrEmpty()) return null

        val type = object : TypeToken<ImageEntity?>() {}.type
        return gson.fromJson(imageItem, type)
    }
}