/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 8/20/23, 10:34 AM
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