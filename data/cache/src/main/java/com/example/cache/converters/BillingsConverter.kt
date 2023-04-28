package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.BillingEntity
import com.squareup.moshi.Moshi

class BillingsConverter {

    private val moshi = Moshi.Builder().build()
    @TypeConverter
    fun toJson(billingEntity: BillingEntity?): String? {
        return billingEntity?.let {
            moshi.adapter(BillingEntity::class.java).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(value: String?): BillingEntity? {
        return value?.let {
            moshi.adapter(BillingEntity::class.java).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromBilling(billingEntity: BillingEntity?): String? {
//        if (billingEntity == null) return null
//        return Json.encodeToString(billingEntity)
//    }
//
//    @TypeConverter
//    fun toBilling(billingItem: String?): BillingEntity? {
//        if (billingItem == null) return null
//        return Json.decodeFromString(billingItem)
//    }
}