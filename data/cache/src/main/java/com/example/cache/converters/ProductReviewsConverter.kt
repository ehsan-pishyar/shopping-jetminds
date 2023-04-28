package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductReviewsResponseEntity
import com.squareup.moshi.Moshi

class ProductReviewsConverter {

    private val moshi = Moshi.Builder().build()
    @TypeConverter
    fun toJson(productReviewEntity: ProductReviewsResponseEntity?): String? {
        return productReviewEntity?.let {
            moshi.adapter(ProductReviewsResponseEntity::class.java).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(value: String?): ProductReviewsResponseEntity? {
        return value?.let {
            moshi.adapter(ProductReviewsResponseEntity::class.java).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromProductReviews(productReviews: ProductReviewsResponseEntity?): String? {
//        if (productReviews == null) return null
//        return Json.encodeToString(productReviews)
//    }
//
//    @TypeConverter
//    fun toProductReviews(productReviewsString: String?): ProductReviewsResponseEntity? {
//        if (productReviewsString.isNullOrEmpty()) return null
//        return Json.decodeFromString(productReviewsString)
//    }
}