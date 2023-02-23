package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.CustomersResponseEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CustomersConverter {

    @TypeConverter
    fun fromCustomer(customer: CustomersResponseEntity?): String? {
        if (customer == null) return null
        return Json.encodeToString(customer)
    }

    @TypeConverter
    fun toCustomer(customerString: String?): CustomersResponseEntity? {
        if (customerString.isNullOrEmpty()) return null
        return Json.decodeFromString(customerString)
    }
}