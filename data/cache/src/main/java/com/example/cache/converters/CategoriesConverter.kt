package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.CategoryEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoriesConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(categoryEntity: List<CategoryEntity>?): String?{
        if (categoryEntity.isNullOrEmpty()) return null

        val type = object : TypeToken<List<CategoryEntity>?>() {}.type
        return gson.toJson(categoryEntity, type)
    }

    @TypeConverter
    fun to(categoryItem: String?): List<CategoryEntity>?{
        if (categoryItem.isNullOrEmpty()) return null

        val type = object : TypeToken<List<CategoryEntity>?>() {}.type
        return gson.fromJson(categoryItem, type)
    }
}