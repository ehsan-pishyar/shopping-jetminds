package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductVariationsResponseEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ProductVariationsConverter {

    @TypeConverter
    fun fromProductVariations(productVariations: ProductVariationsResponseEntity?): String? {
        if (productVariations == null) return null
        return Json.encodeToString(productVariations)
    }

    @TypeConverter
    fun toProductVariations(productVariationsString: String?): ProductVariationsResponseEntity? {
        if (productVariationsString.isNullOrEmpty()) return null
        return Json.decodeFromString(productVariationsString)
    }
}