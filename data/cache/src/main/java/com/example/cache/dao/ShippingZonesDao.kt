package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cache.models.ShippingZonesResponseEntity

@Dao
interface ShippingZonesDao {

    @Query("SELECT * FROM `shipping_zones_table`")
    suspend fun fetchShippingZones(): List<ShippingZonesResponseEntity>
}