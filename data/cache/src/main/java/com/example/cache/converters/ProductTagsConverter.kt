package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductTagsResponseEntity
import com.squareup.moshi.Moshi

class ProductTagsConverter {

    private val moshi = Moshi.Builder().build()
    @TypeConverter
    fun toJson(productTagEntity: ProductTagsResponseEntity?): String? {
        return productTagEntity?.let {
            moshi.adapter(ProductTagsResponseEntity::class.java).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(value: String?): ProductTagsResponseEntity? {
        return value?.let {
            moshi.adapter(ProductTagsResponseEntity::class.java).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromProductTags(productTags: ProductTagsResponseEntity?): String? {
//        if (productTags == null) return null
//        return Json.encodeToString(productTags)
//    }
//
//    @TypeConverter
//    fun toProductTags(productTagsString: String?): ProductTagsResponseEntity? {
//        if (productTagsString.isNullOrEmpty()) return null
//        return Json.decodeFromString(productTagsString)
//    }
}