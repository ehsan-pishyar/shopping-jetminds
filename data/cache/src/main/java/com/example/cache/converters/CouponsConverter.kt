package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.CouponsResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CouponsConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(couponsEntity: CouponsResponseEntity?): String?{
        if (couponsEntity == null) return null

        val type = object : TypeToken<CouponsResponseEntity?>() {}.type
        return gson.toJson(couponsEntity, type)
    }

    @TypeConverter
    fun to(couponsItem: String?): CouponsResponseEntity?{
        if (couponsItem.isNullOrEmpty()) return null

        val type = object : TypeToken<CouponsResponseEntity?>() {}.type
        return gson.fromJson(couponsItem, type)
    }
}