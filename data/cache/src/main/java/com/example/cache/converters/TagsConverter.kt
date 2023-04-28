package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.TagEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class TagsConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun toJsonList(tagsEntity: List<TagEntity>?): String? {
        return tagsEntity?.let {
            val type = Types.newParameterizedType(List::class.java, TagEntity::class.java)
            moshi.adapter<List<TagEntity>>(type).toJson(it)
        }
    }

    @TypeConverter
    fun fromJsonList(value: String?): List<TagEntity>? {
        return value?.let {
            val type = Types.newParameterizedType(List::class.java, TagEntity::class.java)
            moshi.adapter<List<TagEntity>>(type).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromTags(tags: List<TagEntity>?): String? {
//        if (tags == null) return null
//        return Json.encodeToString(tags)
//    }
//
//    @TypeConverter
//    fun toTags(tagsItem: String?): List<TagEntity>? {
//        if (tagsItem == null) return null
//        return Json.decodeFromString(tagsItem)
//    }
}