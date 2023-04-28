package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.OrdersResponseEntity
import com.squareup.moshi.Moshi

class OrdersConverter {

    private val moshi = Moshi.Builder().build()
    @TypeConverter
    fun toJson(ordersResponseEntity: OrdersResponseEntity?): String? {
        return ordersResponseEntity?.let {
            moshi.adapter(OrdersResponseEntity::class.java).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(value: String?): OrdersResponseEntity? {
        return value?.let {
            moshi.adapter(OrdersResponseEntity::class.java).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromOrder(order: OrdersResponseEntity?): String? {
//        if (order == null) return null
//        return Json.encodeToString(order)
//    }
//
//    @TypeConverter
//    fun toOrder(orderString: String?): OrdersResponseEntity? {
//        if (orderString.isNullOrEmpty()) return null
//        return Json.decodeFromString(orderString)
//    }
}