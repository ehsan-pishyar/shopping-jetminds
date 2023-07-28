package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductTagsResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductTagsConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(productTagEntity: ProductTagsResponseEntity?): String?{
        if (productTagEntity == null) return null

        val type = object : TypeToken<ProductTagsResponseEntity?>() {}.type
        return gson.toJson(productTagEntity, type)
    }

    @TypeConverter
    fun to(productTagItem: String?): ProductTagsResponseEntity?{
        if (productTagItem.isNullOrEmpty()) return null

        val type = object : TypeToken<ProductTagsResponseEntity?>() {}.type
        return gson.fromJson(productTagItem, type)
    }
}