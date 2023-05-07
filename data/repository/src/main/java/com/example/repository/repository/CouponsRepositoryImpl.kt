package com.example.repository.repository

import com.example.cache.dao.CouponsDao
import com.example.cache.models.CouponsResponseEntity
import com.example.domain.models.CouponsResponse
import com.example.domain.repositories.CouponsRepository
import com.example.network.ApiService
import com.example.network.models.CouponsResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class CouponsRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: CouponsDao
): CouponsRepository{

    override fun getCoupons(): Flow<List<CouponsResponse>> {
        return dao.fetchCoupons().map { couponsEntity ->
            couponsEntity.map(CouponsResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshCoupons()
            }
        }
    }

    override fun getCouponDetails(couponId: Int): Flow<CouponsResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun refreshCoupons() {
        api.getCoupons().also { couponsResponseDtos ->
            dao.deleteAndInsertCoupons(
                coupons = couponsResponseDtos.map(
                    CouponsResponseDto::toEntity
                )
            )
        }
    }
}