package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductCategoriesResponseEntity
import com.squareup.moshi.Moshi

class ProductCategoriesConverter {

    private val moshi = Moshi.Builder().build()
    @TypeConverter
    fun toJson(productCategory: ProductCategoriesResponseEntity?): String? {
        return productCategory?.let {
            moshi.adapter(ProductCategoriesResponseEntity::class.java).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(value: String?): ProductCategoriesResponseEntity? {
        return value?.let {
            moshi.adapter(ProductCategoriesResponseEntity::class.java).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromProductCategory(productCategory: ProductCategoriesResponseEntity?): String? {
//        if (productCategory == null) return null
//        return Json.encodeToString(productCategory)
//    }
//
//    @TypeConverter
//    fun toProductCategory(productCategoryString: String?): ProductCategoriesResponseEntity? {
//        if (productCategoryString.isNullOrEmpty()) return null
//        return Json.decodeFromString(productCategoryString)
//    }
}