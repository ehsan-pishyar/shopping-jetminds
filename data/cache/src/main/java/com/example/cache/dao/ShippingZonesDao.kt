package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.models.ProductCategoriesResponseEntity
import com.example.cache.models.ShippingZonesResponseEntity

@Dao
interface ShippingZonesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShippingZones(shippingZones: List<ShippingZonesResponseEntity>)

    @Query("SELECT * FROM `shipping_zones_table`")
    suspend fun fetchShippingZones(): List<ShippingZonesResponseEntity>

    @Query("SELECT COUNT(*) FROM `shipping_zones_table`")
    suspend fun isShippingZonesCacheAvailable(): Int
}