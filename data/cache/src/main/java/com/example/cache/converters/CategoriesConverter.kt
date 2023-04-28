package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.CategoryEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class CategoriesConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun toJsonList(categories: List<CategoryEntity>?): String? {
        return categories?.let {
            val type = Types.newParameterizedType(List::class.java, CategoryEntity::class.java)
            moshi.adapter<List<CategoryEntity>>(type).toJson(it)
        }
    }

    @TypeConverter
    fun fromJsonList(value: String?): List<CategoryEntity>? {
        return value?.let {
            val type = Types.newParameterizedType(List::class.java, CategoryEntity::class.java)
            moshi.adapter<List<CategoryEntity>>(type).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromCategories(categories: List<CategoryEntity>?): String? {
//        if (categories.isNullOrEmpty()) return null
//        return Json.encodeToString(categories)
//    }
//
//    @TypeConverter
//    fun toCategories(categoriesItem: String?): List<CategoryEntity>? {
//        if (categoriesItem == null) return null
//        return Json.decodeFromString(categoriesItem)
//    }
}