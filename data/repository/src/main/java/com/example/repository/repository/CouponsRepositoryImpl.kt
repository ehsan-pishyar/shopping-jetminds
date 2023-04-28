package com.example.repository.repository

import com.example.cache.dao.CouponsDao
import com.example.domain.models.CouponsResponse
import com.example.domain.repositories.CouponsRepository
import com.example.domain.utils.ServiceResult
import com.example.network.ApiService
import com.example.network.models.CouponsResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class CouponsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val couponsDao: CouponsDao
): CouponsRepository{
    override fun getCoupons(): Flow<ServiceResult<List<CouponsResponse>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCouponDetails(couponId: Int): ServiceResult<CouponsResponse> {
        TODO("Not yet implemented")
    }
}