package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductCategoriesResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductCategoriesConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(productCategoryEntity: ProductCategoriesResponseEntity?): String?{
        if (productCategoryEntity == null) return null

        val type = object : TypeToken<ProductCategoriesResponseEntity?>() {}.type
        return gson.toJson(productCategoryEntity, type)
    }

    @TypeConverter
    fun to(productCategoryItem: String?): ProductCategoriesResponseEntity?{
        if (productCategoryItem.isNullOrEmpty()) return null

        val type = object : TypeToken<ProductCategoriesResponseEntity?>() {}.type
        return gson.fromJson(productCategoryItem, type)
    }
}