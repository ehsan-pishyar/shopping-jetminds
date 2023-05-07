package com.example.domain.use_cases.coupons

import com.example.domain.models.CouponsResponse
import com.example.domain.repositories.CouponsRepository
import com.example.domain.utils.Result
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetCouponDetailsUseCase constructor(
    private val couponsRepository: CouponsRepository
) {

    operator fun invoke(couponId: Int): Flow<Result<CouponsResponse>> =
        couponsRepository.getCouponDetails(couponId).asResult()
}