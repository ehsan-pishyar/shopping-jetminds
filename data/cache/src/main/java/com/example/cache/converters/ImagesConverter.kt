package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ImageEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ImagesConverter {

    @TypeConverter
    fun fromImage(imageEntity: ImageEntity?): String? {
        if (imageEntity == null) return null
        return Json.encodeToString(imageEntity)
    }

    @TypeConverter
    fun toImage(imagesItem: String?): ImageEntity? {
        if (imagesItem == null) return null
        return Json.decodeFromString(imagesItem)
    }

    @TypeConverter
    fun fromImages(imageEntity: List<ImageEntity>?): String? {
        if (imageEntity == null) return null
        return Json.encodeToString(imageEntity)
    }

    @TypeConverter
    fun toImages(imagesItem: String?): List<ImageEntity>? {
        if (imagesItem == null) return null
        return Json.decodeFromString(imagesItem)
    }
}