package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.CustomersResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CustomersConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(customerEntity: CustomersResponseEntity?): String?{
        if (customerEntity == null) return null

        val type = object : TypeToken<CustomersResponseEntity?>() {}.type
        return gson.toJson(customerEntity, type)
    }

    @TypeConverter
    fun to(customerItem: String?): CustomersResponseEntity?{
        if (customerItem.isNullOrEmpty()) return null

        val type = object : TypeToken<CustomersResponseEntity?>() {}.type
        return gson.fromJson(customerItem, type)
    }
}