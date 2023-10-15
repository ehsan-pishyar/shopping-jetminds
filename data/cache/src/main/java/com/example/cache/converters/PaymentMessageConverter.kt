package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.PaymentMessageEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PaymentMessageConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(paymentMessageEntity: PaymentMessageEntity?): String?{
        if (paymentMessageEntity == null) return null

        val type = object : TypeToken<PaymentMessageEntity?>() {}.type
        return gson.toJson(paymentMessageEntity, type)
    }

    @TypeConverter
    fun to(paymentMessageItem: String?): PaymentMessageEntity?{
        if (paymentMessageItem.isNullOrEmpty()) return null

        val type = object : TypeToken<PaymentMessageEntity?>() {}.type
        return gson.fromJson(paymentMessageItem, type)
    }
}