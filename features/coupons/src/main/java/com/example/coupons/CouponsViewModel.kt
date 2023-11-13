/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 8/22/23, 11:50 PM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

    private var _couponsState = MutableStateFlow(MainCouponsUiState(CouponsUiState.Loading))
    val couponsState = _couponsState.asStateFlow()

    private var _couponDetailsState = MutableStateFlow(
        MainCouponDetailsUiState(
            CouponDetailsUiState.Loading
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
                    ServiceResult.Loading -> CouponsUiState.Loading
                    is ServiceResult.Success -> CouponsUiState.Success(coupons = couponsResult.data)
                    is ServiceResult.Error -> CouponsUiState.Error(message = couponsResult.throwable?.message!!)
                }
                _couponsState.value =
                    MainCouponsUiState(couponsUiState = couponsUiStateResult)
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
                _couponDetailsState.value =
                    MainCouponDetailsUiState(couponDetailsUiState = couponDetailsUiStateResult)
            }
        }
    }
}