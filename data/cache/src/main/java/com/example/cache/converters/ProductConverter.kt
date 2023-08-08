package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductsResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(productEntity: ProductsResponseEntity?): String?{
        if (productEntity == null) return null

        val type = object : TypeToken<ProductsResponseEntity?>() {}.type
        return gson.toJson(productEntity, type)
    }

    @TypeConverter
    fun to(productItem: String?): ProductsResponseEntity?{
        if (productItem.isNullOrEmpty()) return null

        val type = object : TypeToken<ProductsResponseEntity?>() {}.type
        return gson.fromJson(productItem, type)
    }
}