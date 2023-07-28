package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.BillingEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class BillingsConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(billingEntity: BillingEntity?): String?{
        if (billingEntity == null) return null

        val type = object : TypeToken<BillingEntity?>() {}.type
        return gson.toJson(billingEntity, type)
    }

    @TypeConverter
    fun to(billingItem: String?): BillingEntity?{
        if (billingItem.isNullOrEmpty()) return null

        val type = object : TypeToken<BillingEntity?>() {}.type
        return gson.fromJson(billingItem, type)
    }
}