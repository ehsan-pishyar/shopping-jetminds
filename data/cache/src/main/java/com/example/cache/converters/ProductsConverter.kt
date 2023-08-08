package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductsResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductsConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(productsEntity: List<ProductsResponseEntity>?): String?{
        if (productsEntity.isNullOrEmpty()) return null

        val type = object : TypeToken<List<ProductsResponseEntity>?>() {}.type
        return gson.toJson(productsEntity, type)
    }

    @TypeConverter
    fun to(productItems: String?): List<ProductsResponseEntity>?{
        if (productItems.isNullOrEmpty()) return null

        val type = object : TypeToken<List<ProductsResponseEntity>?>() {}.type
        return gson.fromJson(productItems, type)
    }
}