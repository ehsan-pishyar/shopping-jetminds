package com.example.domain.use_cases.coupons

import com.example.domain.models.CouponsResponse
import com.example.domain.repositories.CouponsRepository
import com.example.domain.utils.ServiceResult

class GetCouponDetailsUseCase constructor(
    private val couponsRepository: CouponsRepository
) {

    suspend operator fun invoke(couponId: Int): ServiceResult<CouponsResponse> =
        couponsRepository.getCouponDetails(couponId)
}