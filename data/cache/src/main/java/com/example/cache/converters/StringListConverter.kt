package com.example.cache.converters

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class StringListConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun toJson(ints: List<String>?): String? {
        return ints?.let {
            val type = Types.newParameterizedType(List::class.java, String::class.javaPrimitiveType)
            moshi.adapter<List<String>>(type).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(jsonString: String?): List<String>? {
        return jsonString?.let {
            val type = Types.newParameterizedType(List::class.java, String::class.javaPrimitiveType)
            moshi.adapter<List<String>>(type).fromJson(it)
        }
    }
}