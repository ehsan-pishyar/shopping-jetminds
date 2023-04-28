package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductShippingClassesResponseEntity
import com.squareup.moshi.Moshi

class ProductShippingClassesConverter {

    private val moshi = Moshi.Builder().build()
    @TypeConverter
    fun toJson(productShippingClassEntity: ProductShippingClassesResponseEntity?): String? {
        return productShippingClassEntity?.let {
            moshi.adapter(ProductShippingClassesResponseEntity::class.java).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(value: String?): ProductShippingClassesResponseEntity? {
        return value?.let {
            moshi.adapter(ProductShippingClassesResponseEntity::class.java).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromProductShippingClass(productShippingClass: ProductShippingClassesResponseEntity?): String? {
//        if (productShippingClass == null) return null
//        return Json.encodeToString(productShippingClass)
//    }
//
//    @TypeConverter
//    fun toProductShippingClass(productShippingClassString: String?): ProductShippingClassesResponseEntity? {
//        if (productShippingClassString.isNullOrEmpty()) return null
//        return Json.decodeFromString(productShippingClassString)
//    }
}