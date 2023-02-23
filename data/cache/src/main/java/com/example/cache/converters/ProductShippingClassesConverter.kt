package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductShippingClassesResponseEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ProductShippingClassesConverter {

    @TypeConverter
    fun fromProductShippingClass(productShippingClass: ProductShippingClassesResponseEntity?): String? {
        if (productShippingClass == null) return null
        return Json.encodeToString(productShippingClass)
    }

    @TypeConverter
    fun toProductShippingClass(productShippingClassString: String?): ProductShippingClassesResponseEntity? {
        if (productShippingClassString.isNullOrEmpty()) return null
        return Json.decodeFromString(productShippingClassString)
    }
}