package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.ProductReviewsResponseEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ProductReviewsConverter {

    @TypeConverter
    fun fromProductReviews(productReviews: ProductReviewsResponseEntity?): String? {
        if (productReviews == null) return null
        return Json.encodeToString(productReviews)
    }

    @TypeConverter
    fun toProductReviews(productReviewsString: String?): ProductReviewsResponseEntity? {
        if (productReviewsString.isNullOrEmpty()) return null
        return Json.decodeFromString(productReviewsString)
    }
}