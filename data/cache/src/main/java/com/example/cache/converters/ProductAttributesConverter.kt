package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductAttributesResponseEntity
import com.squareup.moshi.Moshi

class ProductAttributesConverter {

    private val moshi = Moshi.Builder().build()
    @TypeConverter
    fun toJson(productAttr: ProductAttributesResponseEntity?): String? {
        return productAttr?.let {
            moshi.adapter(ProductAttributesResponseEntity::class.java).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(value: String?): ProductAttributesResponseEntity? {
        return value?.let {
            moshi.adapter(ProductAttributesResponseEntity::class.java).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromProductAttribute(productAttribute: ProductAttributesResponseEntity?): String? {
//        if (productAttribute == null) return null
//        return Json.encodeToString(productAttribute)
//    }
//
//    @TypeConverter
//    fun toProductAttribute(productAttributeString: String?): ProductAttributesResponseEntity? {
//        if (productAttributeString.isNullOrEmpty()) return null
//        return Json.decodeFromString(productAttributeString)
//    }
}