package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cache.models.CouponsResponseEntity

@Dao
interface CouponsDao {

    @Query("SELECT * FROM `coupons_table`")
    suspend fun fetchCoupons(): List<CouponsResponseEntity>

    @Query("SELECT * FROM `coupons_table` WHERE id = :couponId")
    suspend fun fetchCouponDetails(couponId: Int): CouponsResponseEntity
}