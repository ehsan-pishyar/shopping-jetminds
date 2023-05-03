package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.CouponsResponseEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CouponsConverter {

    @TypeConverter
    fun fromCoupon(coupon: CouponsResponseEntity?): String?{
        if (coupon == null) return null
        return Json.encodeToString(coupon)
    }

    @TypeConverter
    fun toCoupon(couponString: String?): CouponsResponseEntity?{
        if (couponString.isNullOrEmpty()) return null
        return Json.decodeFromString(couponString)
    }
}