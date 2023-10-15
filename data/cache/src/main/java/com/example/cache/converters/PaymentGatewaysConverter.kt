package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.PaymentGatewaysResponseEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class PaymentGatewaysConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(gatewaysEntity: List<PaymentGatewaysResponseEntity>?): String?{
        if (gatewaysEntity.isNullOrEmpty()) return null

        val type = object : TypeToken<List<PaymentGatewaysResponseEntity>?>() {}.type
        return gson.toJson(gatewaysEntity, type)
    }

    @TypeConverter
    fun to(gatewayItem: String?): List<PaymentGatewaysResponseEntity>?{
        if (gatewayItem.isNullOrEmpty()) return null

        val type = object : TypeToken<List<PaymentGatewaysResponseEntity>?>() {}.type
        return gson.fromJson(gatewayItem, type)
    }
}