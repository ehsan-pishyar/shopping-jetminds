package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.cache.models.ShippingZonesResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ShippingZonesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreShippingZones(shippingZones: List<ShippingZonesResponseEntity>)

    @Query("SELECT * FROM `shipping_zones_table`")
    fun fetchShippingZones(): Flow<List<ShippingZonesResponseEntity>>

    @Query("DELETE FROM `shipping_zones_table`")
    suspend fun deleteShippingZones()

    @Transaction
    suspend fun deleteAndInsertShippingZones(shippingZones: List<ShippingZonesResponseEntity>) {
        deleteShippingZones()
        insertOrIgnoreShippingZones(shippingZones)
    }
}