package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.BillingEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class BillingsConverter {

    @TypeConverter
    fun fromBilling(billingEntity: BillingEntity?): String? {
        if (billingEntity == null) return null
        return Json.encodeToString(billingEntity)
    }

    @TypeConverter
    fun toBilling(billingItem: String?): BillingEntity? {
        if (billingItem == null) return null
        return Json.decodeFromString(billingItem)
    }
}