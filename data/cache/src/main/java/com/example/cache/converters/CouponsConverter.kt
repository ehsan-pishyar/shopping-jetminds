package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.CouponsResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CouponsConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromCoupons(coupons: CouponsResponseEntity?): String?{
        if (coupons == null) return null

        val type = object : TypeToken<CouponsResponseEntity?>() {}.type
        return gson.toJson(coupons, type)
    }

    @TypeConverter
    fun toCoupons(couponsItem: String?): CouponsResponseEntity?{
        if (couponsItem.isNullOrEmpty()) return null

        val type = object : TypeToken<CouponsResponseEntity?>() {}.type
        return gson.fromJson(couponsItem, type)
    }
}