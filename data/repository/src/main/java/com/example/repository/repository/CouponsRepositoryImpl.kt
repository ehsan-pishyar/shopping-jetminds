package com.example.repository.repository

import com.example.cache.dao.CouponsDao
import com.example.domain.models.CouponsResponse
import com.example.domain.repositories.CouponsRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CouponsRepositoryImpl @Inject constructor(
    apiService: ApiService,
    couponsDao: CouponsDao
): CouponsRepository{

    override fun getCoupons(): Flow<ServiceResult<List<CouponsResponse>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCouponDetails(couponId: Int): ServiceResult<CouponsResponse> {
        TODO("Not yet implemented")
    }
}