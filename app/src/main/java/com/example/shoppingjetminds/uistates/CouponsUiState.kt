package com.example.shoppingjetminds.uistates

import com.example.domain.models.CouponsResponse

sealed interface CouponsUiState {
    object Loading: CouponsUiState
    data class Success(val coupons: List<CouponsResponse>): CouponsUiState
    data class Error(val message: String): CouponsUiState
}

sealed interface CouponDetailsUiState {
    object Loading: CouponDetailsUiState
    data class Success(val couponDetails: CouponsResponse): CouponDetailsUiState
    data class Error(val message: String): CouponDetailsUiState
}

data class MainCouponsUiState(
    val couponsUiState: CouponsUiState
)

data class MainCouponDetailsUiState(
    val couponDetailsUiState: CouponDetailsUiState
)