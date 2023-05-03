package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.CategoryEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CategoriesConverter {

    @TypeConverter
    fun fromCategories(categories: List<CategoryEntity>?): String? {
        if (categories.isNullOrEmpty()) return null
        return Json.encodeToString(categories)
    }

    @TypeConverter
    fun toCategories(categoriesItem: String?): List<CategoryEntity>? {
        if (categoriesItem == null) return null
        return Json.decodeFromString(categoriesItem)
    }
}