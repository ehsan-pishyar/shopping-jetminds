package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.TaxLineEntity
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class TaxLinesConverter {

    @TypeConverter
    fun fromTaxLines(taxLines: List<TaxLineEntity>?): String? {
        if (taxLines == null) return null
        return Json.encodeToString(taxLines)
    }

    @TypeConverter
    fun toTaxLines(taxLinesString: String?): List<TaxLineEntity>? {
        if (taxLinesString == null) return null
        return Json.decodeFromString(taxLinesString)
    }
}