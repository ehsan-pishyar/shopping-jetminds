package com.example.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class IntegerListConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(int: List<Int>?): String?{
        if (int.isNullOrEmpty()) return null

        val type = object : TypeToken<List<Int>?>() {}.type
        return gson.toJson(int, type)
    }

    @TypeConverter
    fun to(intItem: String?): List<Int>?{
        if (intItem.isNullOrEmpty()) return null

        val type = object : TypeToken<List<Int>?>() {}.type
        return gson.fromJson(intItem, type)
    }
}