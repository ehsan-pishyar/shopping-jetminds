package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ShippingLineEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class ShippingLinesConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun toJsonList(shippingLinesEntity: List<ShippingLineEntity>?): String? {
        return shippingLinesEntity?.let {
            val type = Types.newParameterizedType(List::class.java, ShippingLineEntity::class.java)
            moshi.adapter<List<ShippingLineEntity>>(type).toJson(it)
        }
    }

    @TypeConverter
    fun fromJsonList(value: String?): List<ShippingLineEntity>? {
        return value?.let {
            val type = Types.newParameterizedType(List::class.java, ShippingLineEntity::class.java)
            moshi.adapter<List<ShippingLineEntity>>(type).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromShippingLines(shippingLines: List<ShippingLineEntity>?): String? {
//        if (shippingLines == null) return null
//        return Json.encodeToString(shippingLines)
//    }
//
//    @TypeConverter
//    fun toShippingLine(shippingLinesString: String?): List<ShippingLineEntity>? {
//        if (shippingLinesString == null) return null
//        return Json.decodeFromString(shippingLinesString)
//    }
}