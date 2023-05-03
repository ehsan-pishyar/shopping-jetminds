package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductCategoriesResponseEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ProductCategoriesConverter {

    @TypeConverter
    fun fromProductCategory(productCategory: ProductCategoriesResponseEntity?): String? {
        if (productCategory == null) return null
        return Json.encodeToString(productCategory)
    }

    @TypeConverter
    fun toProductCategory(productCategoryString: String?): ProductCategoriesResponseEntity? {
        if (productCategoryString.isNullOrEmpty()) return null
        return Json.decodeFromString(productCategoryString)
    }
}