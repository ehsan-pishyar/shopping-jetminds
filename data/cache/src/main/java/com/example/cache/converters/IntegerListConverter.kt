package com.example.cache.converters

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class IntegerListConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun toJson(ints: List<Int>?): String? {
        return ints?.let {
            val type = Types.newParameterizedType(List::class.java, Int::class.javaPrimitiveType)
            moshi.adapter<List<Int>>(type).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(jsonString: String?): List<Int>? {
        return jsonString?.let {
            val type = Types.newParameterizedType(List::class.java, Int::class.javaPrimitiveType)
            moshi.adapter<List<Int>>(type).fromJson(it)
        }
    }
}