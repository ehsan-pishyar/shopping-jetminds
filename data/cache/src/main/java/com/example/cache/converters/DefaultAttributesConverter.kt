package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.DefaultAttributeEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class DefaultAttributesConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun toJsonList(defaultAttrs: List<DefaultAttributeEntity>?): String? {
        return defaultAttrs?.let {
            val type = Types.newParameterizedType(List::class.java, DefaultAttributeEntity::class.java)
            moshi.adapter<List<DefaultAttributeEntity>>(type).toJson(it)
        }
    }

    @TypeConverter
    fun fromJsonList(value: String?): List<DefaultAttributeEntity>? {
        return value?.let {
            val type = Types.newParameterizedType(List::class.java, DefaultAttributeEntity::class.java)
            moshi.adapter<List<DefaultAttributeEntity>>(type).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromDefaultAttributes(defaultAttributeEntity: List<DefaultAttributeEntity>?): String? {
//        if (defaultAttributeEntity == null) return null
//        return Json.encodeToString(defaultAttributeEntity)
//    }
//
//    @TypeConverter
//    fun toDefaultAttributes(defaultAttributeEntityItems: String?): List<DefaultAttributeEntity>? {
//        if (defaultAttributeEntityItems == null) return null
//        return Json.decodeFromString(defaultAttributeEntityItems)
//    }
}