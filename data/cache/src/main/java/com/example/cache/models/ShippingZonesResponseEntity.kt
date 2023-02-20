package com.example.cache.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.utils.CacheConstants

@Entity(tableName = CacheConstants.SHIPPING_ZONES_TABLE)
data class ShippingZonesResponseEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val order: Int
)