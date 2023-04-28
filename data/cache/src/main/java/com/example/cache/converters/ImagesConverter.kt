package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ImageEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class ImagesConverter {

    private val moshi = Moshi.Builder().build()
    @TypeConverter
    fun toJson(imageEntity: ImageEntity?): String? {
        return imageEntity?.let {
            moshi.adapter(ImageEntity::class.java).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(value: String?): ImageEntity? {
        return value?.let {
            moshi.adapter(ImageEntity::class.java).fromJson(it)
        }
    }

    @TypeConverter
    fun toJsonList(imageEntities: List<ImageEntity>?): String? {
        return imageEntities?.let {
            val type = Types.newParameterizedType(List::class.java, ImageEntity::class.java)
            moshi.adapter<List<ImageEntity>>(type).toJson(it)
        }
    }

    @TypeConverter
    fun fromJsonList(value: String?): List<ImageEntity>? {
        return value?.let {
            val type = Types.newParameterizedType(List::class.java, ImageEntity::class.java)
            moshi.adapter<List<ImageEntity>>(type).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromImage(imageEntity: ImageEntity?): String? {
//        if (imageEntity == null) return null
//        return Json.encodeToString(imageEntity)
//    }
//
//    @TypeConverter
//    fun toImage(imagesItem: String?): ImageEntity? {
//        if (imagesItem == null) return null
//        return Json.decodeFromString(imagesItem)
//    }
//
//    @TypeConverter
//    fun fromImages(imageEntity: List<ImageEntity>?): String? {
//        if (imageEntity == null) return null
//        return Json.encodeToString(imageEntity)
//    }
//
//    @TypeConverter
//    fun toImages(imagesItem: String?): List<ImageEntity>? {
//        if (imagesItem == null) return null
//        return Json.decodeFromString(imagesItem)
//    }
}