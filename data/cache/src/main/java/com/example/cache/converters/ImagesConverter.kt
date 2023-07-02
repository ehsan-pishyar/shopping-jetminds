package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ImageEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ImagesConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromImage(imageEntity: ImageEntity?): String?{
        if (imageEntity == null) return null

        val type = object : TypeToken<ImageEntity?>() {}.type
        return gson.toJson(imageEntity, type)
    }

    @TypeConverter
    fun toImage(imageItem: String?): ImageEntity?{
        if (imageItem.isNullOrEmpty()) return null

        val type = object : TypeToken<ImageEntity?>() {}.type
        return gson.fromJson(imageItem, type)
    }

    @TypeConverter
    fun fromImages(imagesEntity: List<ImageEntity>?): String?{
        if (imagesEntity.isNullOrEmpty()) return null

        val type = object : TypeToken<List<ImageEntity>?>() {}.type
        return gson.toJson(imagesEntity, type)
    }

    @TypeConverter
    fun toImages(imageItems: String?): List<ImageEntity>?{
        if (imageItems.isNullOrEmpty()) return null

        val type = object : TypeToken<List<ImageEntity>?>() {}.type
        return gson.fromJson(imageItems, type)
    }
}