package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.SettingsEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SettingsConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(settingsEntity: SettingsEntity?): String?{
        if (settingsEntity == null) return null

        val type = object : TypeToken<SettingsEntity?>() {}.type
        return gson.toJson(settingsEntity, type)
    }

    @TypeConverter
    fun to(settingsItem: String?): SettingsEntity?{
        if (settingsItem.isNullOrEmpty()) return null

        val type = object : TypeToken<SettingsEntity?>() {}.type
        return gson.fromJson(settingsItem, type)
    }
}