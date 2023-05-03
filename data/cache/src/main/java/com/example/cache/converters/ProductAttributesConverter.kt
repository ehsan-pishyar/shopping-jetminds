package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductAttributesResponseEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ProductAttributesConverter {

    @TypeConverter
    fun fromProductAttribute(productAttribute: ProductAttributesResponseEntity?): String? {
        if (productAttribute == null) return null
        return Json.encodeToString(productAttribute)
    }

    @TypeConverter
    fun toProductAttribute(productAttributeString: String?): ProductAttributesResponseEntity? {
        if (productAttributeString.isNullOrEmpty()) return null
        return Json.decodeFromString(productAttributeString)
    }
}