package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductsResponseEntity
import com.squareup.moshi.Moshi

class ProductsConverter {

    private val moshi = Moshi.Builder().build()
    @TypeConverter
    fun toJson(productEntity: ProductsResponseEntity?): String? {
        return productEntity?.let {
            moshi.adapter(ProductsResponseEntity::class.java).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(value: String?): ProductsResponseEntity? {
        return value?.let {
            moshi.adapter(ProductsResponseEntity::class.java).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromProducts(products: ProductsResponseEntity?): String? {
//        if (products == null) return null
//        return Json.encodeToString(products)
//    }
//
//    @TypeConverter
//    fun toProducts(productsString: String?): ProductsResponseEntity? {
//        if (productsString.isNullOrEmpty()) return null
//        return Json.decodeFromString(productsString)
//    }
}