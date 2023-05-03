package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductsResponseEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ProductsConverter {

    @TypeConverter
    fun fromProducts(products: ProductsResponseEntity?): String? {
        if (products == null) return null
        return Json.encodeToString(products)
    }

    @TypeConverter
    fun toProducts(productsString: String?): ProductsResponseEntity? {
        if (productsString.isNullOrEmpty()) return null
        return Json.decodeFromString(productsString)
    }
}