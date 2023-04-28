package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.CustomersResponseEntity
import com.squareup.moshi.Moshi

class CustomersConverter {

    private val moshi = Moshi.Builder().build()
    @TypeConverter
    fun toJson(customersResponseEntity: CustomersResponseEntity?): String? {
        return customersResponseEntity?.let {
            moshi.adapter(CustomersResponseEntity::class.java).toJson(it)
        }
    }

    @TypeConverter
    fun fromJson(value: String?): CustomersResponseEntity? {
        return value?.let {
            moshi.adapter(CustomersResponseEntity::class.java).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromCustomer(customer: CustomersResponseEntity?): String? {
//        if (customer == null) return null
//        return Json.encodeToString(customer)
//    }
//
//    @TypeConverter
//    fun toCustomer(customerString: String?): CustomersResponseEntity? {
//        if (customerString.isNullOrEmpty()) return null
//        return Json.decodeFromString(customerString)
//    }
}