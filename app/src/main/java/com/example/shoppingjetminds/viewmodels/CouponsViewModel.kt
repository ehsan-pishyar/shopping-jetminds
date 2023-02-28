package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import com.example.domain.use_cases.coupons.GetCouponDetailsUseCase
import com.example.domain.use_cases.coupons.GetCouponsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CouponsViewModel @Inject constructor(
    private val getCouponsUseCase: GetCouponsUseCase,
    private val getCouponDetailsUseCase: GetCouponDetailsUseCase
): ViewModel() {
}