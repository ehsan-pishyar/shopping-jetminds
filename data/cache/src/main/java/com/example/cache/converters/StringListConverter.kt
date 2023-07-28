package com.example.cache.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class StringListConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(string: List<String>?): String?{
        if (string.isNullOrEmpty()) return null

        val type = object : TypeToken<List<String>?>() {}.type
        return gson.toJson(string, type)
    }

    @TypeConverter
    fun to(stringItem: String?): List<String>?{
        if (stringItem.isNullOrEmpty()) return null

        val type = object : TypeToken<List<String>?>() {}.type
        return gson.fromJson(stringItem, type)
    }
}