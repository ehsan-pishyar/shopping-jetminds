package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.coupons.GetCouponDetailsUseCase
import com.example.domain.use_cases.coupons.GetCouponsUseCase
import com.example.domain.utils.ServiceResult
import com.example.shoppingjetminds.uistates.CouponDetailsUiState
import com.example.shoppingjetminds.uistates.CouponsUiState
import com.example.shoppingjetminds.uistates.MainCouponDetailsUiState
import com.example.shoppingjetminds.uistates.MainCouponsUiState
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

    private var _couponsState = MutableStateFlow(MainCouponsUiState(CouponsUiState.Loading))
    val couponsState = _couponsState.asStateFlow()

    private var _couponDetailsState = MutableStateFlow(MainCouponDetailsUiState(CouponDetailsUiState.Loading))
    val couponDetailsState = _couponDetailsState.asStateFlow()

    init {
        getCoupons()
    }

    private fun getCoupons() {
        viewModelScope.launch {
            getCouponsUseCase.invoke().collect { couponsResult ->
                val couponsUiStateResult = when (couponsResult) {
                    ServiceResult.Loading -> CouponsUiState.Loading
                    is ServiceResult.Success -> CouponsUiState.Success(coupons = couponsResult.data)
                    is ServiceResult.Error -> CouponsUiState.Error(message = couponsResult.throwable?.message!!)
                }
                _couponsState.value = MainCouponsUiState(couponsUiState = couponsUiStateResult)
            }
        }
    }

    fun getCouponDetails(couponId: Int) {
        viewModelScope.launch {
            getCouponDetailsUseCase.invoke(couponId = couponId).collect { couponDetailsResult ->
                val couponDetailsUiStateResult = when (couponDetailsResult) {
                    ServiceResult.Loading -> CouponDetailsUiState.Loading
                    is ServiceResult.Success -> CouponDetailsUiState.Success(couponDetails = couponDetailsResult.data)
                    is ServiceResult.Error -> CouponDetailsUiState.Error(message = couponDetailsResult.throwable?.message!!)
                }
                _couponDetailsState.value = MainCouponDetailsUiState(couponDetailsUiState = couponDetailsUiStateResult)
            }
        }
    }
}