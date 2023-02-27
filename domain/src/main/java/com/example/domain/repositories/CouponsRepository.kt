package com.example.domain.repositories

import com.example.domain.models.CouponsResponse
import com.example.domain.utils.ServiceResult
import kotlinx.coroutines.flow.Flow

interface CouponsRepository {

    fun getCoupons(): Flow<ServiceResult<List<CouponsResponse>>>
    suspend fun getCouponDetails(couponId: Int): ServiceResult<CouponsResponse>
}