/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/29/23, 10:51 PM
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
import com.example.cache.models.CouponsResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CouponsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreCoupons(coupons: List<CouponsResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCouponDetails(couponDetails: CouponsResponseEntity)

    @Query("SELECT * FROM `coupons_table`")
    fun fetchCoupons(): Flow<List<CouponsResponseEntity>>

    @Query("SELECT * FROM `coupons_table` WHERE id = :couponId")
    fun fetchCouponDetails(couponId: Int): Flow<CouponsResponseEntity>

    @Query("DELETE FROM `coupons_table`")
    suspend fun deleteCoupons()

    @Transaction
    suspend fun deleteAndInsertCoupons(coupons: List<CouponsResponseEntity>) {
        deleteCoupons()
        insertOrIgnoreCoupons(coupons)
    }
}