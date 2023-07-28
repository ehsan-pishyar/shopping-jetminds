package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.OrdersResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class OrdersConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(orderEntity: OrdersResponseEntity?): String?{
        if (orderEntity == null) return null

        val type = object : TypeToken<OrdersResponseEntity?>() {}.type
        return gson.toJson(orderEntity, type)
    }

    @TypeConverter
    fun to(orderItem: String?): OrdersResponseEntity?{
        if (orderItem.isNullOrEmpty()) return null

        val type = object : TypeToken<OrdersResponseEntity?>() {}.type
        return gson.fromJson(orderItem, type)
    }
}