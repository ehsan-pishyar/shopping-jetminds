package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.LineItemEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class LineItemsConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun toJsonList(lineItems: List<LineItemEntity>?): String? {
        return lineItems?.let {
            val type = Types.newParameterizedType(List::class.java, LineItemEntity::class.java)
            moshi.adapter<List<LineItemEntity>>(type).toJson(it)
        }
    }

    @TypeConverter
    fun fromJsonList(value: String?): List<LineItemEntity>? {
        return value?.let {
            val type = Types.newParameterizedType(List::class.java, LineItemEntity::class.java)
            moshi.adapter<List<LineItemEntity>>(type).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromLineItems(lineItems: List<LineItemEntity>?): String? {
//        if (lineItems == null) return null
//        return Json.encodeToString(lineItems)
//    }
//
//    @TypeConverter
//    fun toLineItems(lineItemsString: String?): List<LineItemEntity>? {
//        if (lineItemsString == null) return null
//        return Json.decodeFromString(lineItemsString)
//    }
}