package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductTagsResponseEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ProductTagsConverter {

    @TypeConverter
    fun fromProductTags(productTags: ProductTagsResponseEntity?): String? {
        if (productTags == null) return null
        return Json.encodeToString(productTags)
    }

    @TypeConverter
    fun toProductTags(productTagsString: String?): ProductTagsResponseEntity? {
        if (productTagsString.isNullOrEmpty()) return null
        return Json.decodeFromString(productTagsString)
    }
}