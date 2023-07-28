package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.TaxEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TaxesConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(taxesEntity: List<TaxEntity>?): String?{
        if (taxesEntity.isNullOrEmpty()) return null

        val type = object : TypeToken<List<TaxEntity>?>() {}.type
        return gson.toJson(taxesEntity, type)
    }

    @TypeConverter
    fun to(taxesItem: String?): List<TaxEntity>?{
        if (taxesItem.isNullOrEmpty()) return null

        val type = object : TypeToken<List<TaxEntity>?>() {}.type
        return gson.fromJson(taxesItem, type)
    }
}