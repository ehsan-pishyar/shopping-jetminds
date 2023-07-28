package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductVariationsResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductVariationsConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(productVariationEntity: ProductVariationsResponseEntity?): String?{
        if (productVariationEntity == null) return null

        val type = object : TypeToken<ProductVariationsResponseEntity?>() {}.type
        return gson.toJson(productVariationEntity, type)
    }

    @TypeConverter
    fun to(productVariationItem: String?): ProductVariationsResponseEntity?{
        if (productVariationItem.isNullOrEmpty()) return null

        val type = object : TypeToken<ProductVariationsResponseEntity?>() {}.type
        return gson.fromJson(productVariationItem, type)
    }
}