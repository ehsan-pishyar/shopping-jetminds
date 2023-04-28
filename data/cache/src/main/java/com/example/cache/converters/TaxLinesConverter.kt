package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.TaxLineEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class TaxLinesConverter {

    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun toJsonList(taxLinesEntity: List<TaxLineEntity>?): String? {
        return taxLinesEntity?.let {
            val type = Types.newParameterizedType(List::class.java, TaxLineEntity::class.java)
            moshi.adapter<List<TaxLineEntity>>(type).toJson(it)
        }
    }

    @TypeConverter
    fun fromJsonList(value: String?): List<TaxLineEntity>? {
        return value?.let {
            val type = Types.newParameterizedType(List::class.java, TaxLineEntity::class.java)
            moshi.adapter<List<TaxLineEntity>>(type).fromJson(it)
        }
    }

//    @TypeConverter
//    fun fromTaxLines(taxLines: List<TaxLineEntity>?): String? {
//        if (taxLines == null) return null
//        return Json.encodeToString(taxLines)
//    }
//
//    @TypeConverter
//    fun toTaxLines(taxLinesString: String?): List<TaxLineEntity>? {
//        if (taxLinesString == null) return null
//        return Json.decodeFromString(taxLinesString)
//    }
}