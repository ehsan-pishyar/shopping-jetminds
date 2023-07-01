package com.example.domain.use_cases.coupons

import com.example.domain.models.CouponsResponse
import com.example.domain.repositories.CouponsRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetCouponsUseCase constructor(
    private val couponsRepository: CouponsRepository
) {

    operator fun invoke(): Flow<ServiceResult<List<CouponsResponse>>> =
        couponsRepository.getCoupons().asResult()
}