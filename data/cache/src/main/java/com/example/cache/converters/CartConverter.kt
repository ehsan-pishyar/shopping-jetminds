package com.example.cache.converters

import androidx.room.TypeConverter
import com.example.cache.models.CartEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CartConverter {

    private val gson = Gson()

    @TypeConverter
    fun from(cartEntity: CartEntity?): String? {
        if (cartEntity == null) return null

        val type = object : TypeToken<CartEntity?>() {}.type
        return gson.toJson(cartEntity, type)
    }

    @TypeConverter
    fun to(cartItem: String?): CartEntity? {
        if (cartItem.isNullOrEmpty()) return null

        val type = object: TypeToken<CartEntity?>() {}.type
        return gson.fromJson(cartItem, type)
    }
}