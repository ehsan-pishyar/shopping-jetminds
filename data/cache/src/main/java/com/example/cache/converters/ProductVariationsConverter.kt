package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductVariationsResponseEntity
import com.squareup.moshi.Moshi

class ProductVariationsConverter {

    private val moshi = Moshi.Builder().build()
    @TypeConverter
    fun toJson(productVariationEntity: ProductVariationsResponseEntity?): String? {
        return productVariationEntity?.let {
            moshi.adapter(ProductVariationsResponseEntity::class.java).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(value: String?): ProductVariationsResponseEntity? {
        return value?.let {
            moshi.adapter(ProductVariationsResponseEntity::class.java).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromProductVariations(productVariations: ProductVariationsResponseEntity?): String? {
//        if (productVariations == null) return null
//        return Json.encodeToString(productVariations)
//    }
//
//    @TypeConverter
//    fun toProductVariations(productVariationsString: String?): ProductVariationsResponseEntity? {
//        if (productVariationsString.isNullOrEmpty()) return null
//        return Json.decodeFromString(productVariationsString)
//    }
}