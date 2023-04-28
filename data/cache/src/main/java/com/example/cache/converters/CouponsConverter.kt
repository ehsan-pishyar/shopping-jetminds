package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.CouponsResponseEntity
import com.squareup.moshi.Moshi

class CouponsConverter {

    private val moshi = Moshi.Builder().build()
    @TypeConverter
    fun toJson(couponsResponseEntity: CouponsResponseEntity?): String? {
        return couponsResponseEntity?.let {
            moshi.adapter(CouponsResponseEntity::class.java).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(value: String?): CouponsResponseEntity? {
        return value?.let {
            moshi.adapter(CouponsResponseEntity::class.java).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromCoupon(coupon: CouponsResponseEntity?): String?{
//        if (coupon == null) return null
//        return Json.encodeToString(coupon)
//    }
//
//    @TypeConverter
//    fun toCoupon(couponString: String?): CouponsResponseEntity?{
//        if (couponString.isNullOrEmpty()) return null
//        return Json.decodeFromString(couponString)
//    }
}