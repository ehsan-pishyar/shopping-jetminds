/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 5/25/23, 12:03 AM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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