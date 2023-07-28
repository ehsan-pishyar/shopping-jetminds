package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.TaxLineEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TaxLinesConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(taxLinesEntity: List<TaxLineEntity>?): String?{
        if (taxLinesEntity.isNullOrEmpty()) return null

        val type = object : TypeToken<List<TaxLineEntity>?>() {}.type
        return gson.toJson(taxLinesEntity, type)
    }

    @TypeConverter
    fun to(taxLinesItem: String?): List<TaxLineEntity>?{
        if (taxLinesItem.isNullOrEmpty()) return null

        val type = object : TypeToken<List<TaxLineEntity>?>() {}.type
        return gson.fromJson(taxLinesItem, type)
    }
}