package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.UserAvatarEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserAvatarConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(avatars: UserAvatarEntity?): String?{
        if (avatars == null) return null

        val type = object : TypeToken<UserAvatarEntity?>() {}.type
        return gson.toJson(avatars, type)
    }

    @TypeConverter
    fun to(avatars: String?): UserAvatarEntity?{
        if (avatars.isNullOrEmpty()) return null

        val type = object : TypeToken<UserAvatarEntity?>() {}.type
        return gson.fromJson(avatars, type)
    }
}