package com.example.domain.repositories

import com.example.domain.models.CouponsResponse
import kotlinx.coroutines.flow.Flow

interface CouponsRepository {

    fun getCoupons(): Flow<List<CouponsResponse>>
    fun getCouponDetails(couponId: Int): Flow<CouponsResponse>
    suspend fun refreshCoupons()
}