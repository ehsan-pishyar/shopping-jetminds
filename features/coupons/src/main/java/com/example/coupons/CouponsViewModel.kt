package com.example.coupons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.coupons.GetCouponDetailsUseCase
import com.example.domain.use_cases.coupons.GetCouponsUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CouponsViewModel @Inject constructor(
    private val getCouponsUseCase: GetCouponsUseCase,
    private val getCouponDetailsUseCase: GetCouponDetailsUseCase
): ViewModel() {

    private var _couponsState = MutableStateFlow(com.example.coupons.MainCouponsUiState(com.example.coupons.CouponsUiState.Loading))
    val couponsState = _couponsState.asStateFlow()

    private var _couponDetailsState = MutableStateFlow(
        com.example.coupons.MainCouponDetailsUiState(
            com.example.coupons.CouponDetailsUiState.Loading
        )
    )
    val couponDetailsState = _couponDetailsState.asStateFlow()

    init {
        getCoupons()
    }

    private fun getCoupons() {
        viewModelScope.launch {
            getCouponsUseCase.invoke().collect { couponsResult ->
                val couponsUiStateResult = when (couponsResult) {
                    ServiceResult.Loading -> com.example.coupons.CouponsUiState.Loading
                    is ServiceResult.Success -> com.example.coupons.CouponsUiState.Success(coupons = couponsResult.data)
                    is ServiceResult.Error -> com.example.coupons.CouponsUiState.Error(message = couponsResult.throwable?.message!!)
                }
                _couponsState.value =
                    com.example.coupons.MainCouponsUiState(couponsUiState = couponsUiStateResult)
            }
        }
    }

    fun getCouponDetails(couponId: Int) {
        viewModelScope.launch {
            getCouponDetailsUseCase.invoke(couponId = couponId).collect { couponDetailsResult ->
                val couponDetailsUiStateResult = when (couponDetailsResult) {
                    ServiceResult.Loading -> com.example.coupons.CouponDetailsUiState.Loading
                    is ServiceResult.Success -> com.example.coupons.CouponDetailsUiState.Success(couponDetails = couponDetailsResult.data)
                    is ServiceResult.Error -> com.example.coupons.CouponDetailsUiState.Error(message = couponDetailsResult.throwable?.message!!)
                }
                _couponDetailsState.value =
                    com.example.coupons.MainCouponDetailsUiState(couponDetailsUiState = couponDetailsUiStateResult)
            }
        }
    }
}