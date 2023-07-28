package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductAttributesResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductAttributesConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(productAttrEntity: ProductAttributesResponseEntity?): String?{
        if (productAttrEntity == null) return null

        val type = object : TypeToken<ProductAttributesResponseEntity?>() {}.type
        return gson.toJson(productAttrEntity, type)
    }

    @TypeConverter
    fun to(productAttrItem: String?): ProductAttributesResponseEntity?{
        if (productAttrItem.isNullOrEmpty()) return null

        val type = object : TypeToken<ProductAttributesResponseEntity?>() {}.type
        return gson.fromJson(productAttrItem, type)
    }
}