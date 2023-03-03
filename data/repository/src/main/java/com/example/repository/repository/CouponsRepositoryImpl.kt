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

    override fun getCoupons(): Flow<ServiceResult<List<CouponsResponse>>> = flow {
        emit(ServiceResult.Loading())

        if (couponsDao.isCouponsCacheAvailable() > 0) {
            emit(ServiceResult.Success(data = couponsDao.fetchCoupons().map { it.toDomain() }))
        }

        val response = try {
            apiService.getCoupons()
        } catch (e: IOException) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ServiceResult.Error(data = null, error = e.message))
        } as CouponsResponseDto

        response.let { coupons ->
            couponsDao.insertCoupons(listOf(coupons.toEntity()))
            emit(ServiceResult.Success(couponsDao.fetchCoupons().map { it.toDomain() }))
        }

        emit(ServiceResult.Loading(isLoading = false))
    }

    override suspend fun getCouponDetails(couponId: Int): ServiceResult<CouponsResponse> {
        val couponsEntity = couponsDao.fetchCouponDetails(couponId)

        if (couponsDao.isCouponsCacheAvailable() > 0) {
            return ServiceResult.Success(data = couponsEntity.toDomain())
        }

        val response = try {
            apiService.getCouponDetails(couponId)
        } catch (e: IOException) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, error = e.message)
        } catch (e: Exception) {
            e.printStackTrace()
            return ServiceResult.Error(data = null, error = e.message)
        } as CouponsResponseDto

        response.let {
            couponsDao.insertCouponDetails(it.toEntity())
            return ServiceResult.Success(couponsDao.fetchCouponDetails(couponId).toDomain())
        }
    }
}