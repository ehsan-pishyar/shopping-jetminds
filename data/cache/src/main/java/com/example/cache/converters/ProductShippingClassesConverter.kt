package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductShippingClassesResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductShippingClassesConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(productShippingClassEntity: ProductShippingClassesResponseEntity?): String?{
        if (productShippingClassEntity == null) return null

        val type = object : TypeToken<ProductShippingClassesResponseEntity?>() {}.type
        return gson.toJson(productShippingClassEntity, type)
    }

    @TypeConverter
    fun to(productShippingClassItem: String?): ProductShippingClassesResponseEntity?{
        if (productShippingClassItem.isNullOrEmpty()) return null

        val type = object : TypeToken<ProductShippingClassesResponseEntity?>() {}.type
        return gson.fromJson(productShippingClassItem, type)
    }
}