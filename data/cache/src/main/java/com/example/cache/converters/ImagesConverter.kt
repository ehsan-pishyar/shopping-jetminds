package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ImageEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ImagesConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(imagesEntity: List<ImageEntity?>?): String?{
        if (imagesEntity.isNullOrEmpty()) return null

        val type = object : TypeToken<List<ImageEntity?>?>() {}.type
        return gson.toJson(imagesEntity, type)
    }

    @TypeConverter
    fun to(imageItems: String?): List<ImageEntity?>?{
        if (imageItems.isNullOrEmpty()) return null

        val type = object : TypeToken<List<ImageEntity?>?>() {}.type
        return gson.fromJson(imageItems, type)
    }
}