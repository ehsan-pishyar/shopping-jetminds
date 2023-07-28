package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductReviewsResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductReviewsConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(productReviewEntity: ProductReviewsResponseEntity?): String?{
        if (productReviewEntity == null) return null

        val type = object : TypeToken<ProductReviewsResponseEntity?>() {}.type
        return gson.toJson(productReviewEntity, type)
    }

    @TypeConverter
    fun to(productReviewItem: String?): ProductReviewsResponseEntity?{
        if (productReviewItem.isNullOrEmpty()) return null

        val type = object : TypeToken<ProductReviewsResponseEntity?>() {}.type
        return gson.fromJson(productReviewItem, type)
    }
}