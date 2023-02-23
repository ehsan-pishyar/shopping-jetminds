package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.OrdersResponseEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class OrdersConverter {

    @TypeConverter
    fun fromOrder(order: OrdersResponseEntity?): String? {
        if (order == null) return null
        return Json.encodeToString(order)
    }

    @TypeConverter
    fun toOrder(orderString: String?): OrdersResponseEntity? {
        if (orderString.isNullOrEmpty()) return null
        return Json.decodeFromString(orderString)
    }
}