package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.models.CouponsResponseEntity
import com.example.cache.models.ProductCategoriesResponseEntity

@Dao
interface CouponsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoupons(coupons: List<CouponsResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCouponDetails(couponDetails: CouponsResponseEntity)

    @Query("SELECT * FROM `coupons_table`")
    suspend fun fetchCoupons(): List<CouponsResponseEntity>

    @Query("SELECT * FROM `coupons_table` WHERE id = :couponId")
    suspend fun fetchCouponDetails(couponId: Int): CouponsResponseEntity

    @Query("SELECT COUNT(*) FROM `coupons_table`")
    suspend fun isCouponsCacheAvailable(): Int
}