package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.AttributeEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class AttributesConverter {

    private val moshi = Moshi.Builder().build()
    @TypeConverter
    fun toJson(attrs: List<AttributeEntity>?): String? {
        return attrs?.let {
            val type = Types.newParameterizedType(List::class.java, AttributeEntity::class.java)
            moshi.adapter<List<AttributeEntity>>(type).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(value: String?): List<AttributeEntity>? {
        return value?.let {
            val type = Types.newParameterizedType(List::class.java, AttributeEntity::class.java)
            moshi.adapter<List<AttributeEntity>>(type).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromAttributes(attributeEntity: List<AttributeEntity>?): String? {
//        if (attributeEntity == null) return null
//        return Json.encodeToString(attributeEntity)
//    }
//
//    @TypeConverter
//    fun toAttributes(attributesItem: String?): List<AttributeEntity>? {
//        if (attributesItem == null) return null
//        return Json.decodeFromString(attributesItem)
//    }
}