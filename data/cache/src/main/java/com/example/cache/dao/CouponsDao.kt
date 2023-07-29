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