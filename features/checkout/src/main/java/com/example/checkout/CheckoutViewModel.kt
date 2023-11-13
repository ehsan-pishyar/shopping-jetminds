/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/15/23, 11:41 PM
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

package com.example.checkout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.payment_gateways.GetPaymentGatewaysUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckoutViewModel @Inject constructor(
    private val getPaymentGatewaysUseCase: GetPaymentGatewaysUseCase
): ViewModel() {

    private var _gatewaysUiState = MutableStateFlow(
        MainPaymentGatewaysUiState(
            PaymentGatewaysUiState.Loading
        )
    )

    val gatewaysUiState = _gatewaysUiState.asStateFlow()

    init {
        getPaymentGateways()
    }
    private fun getPaymentGateways() {
        viewModelScope.launch {
            getPaymentGatewaysUseCase.invoke().collect { gatewaysResults ->
                val paymentGatewayUiStateResult = when (gatewaysResults) {
                    ServiceResult.Loading -> PaymentGatewaysUiState.Loading
                    is ServiceResult.Success -> PaymentGatewaysUiState.Success(
                        gateways = gatewaysResults.data
                    )
                    is ServiceResult.Error -> PaymentGatewaysUiState.Error(
                        throwable = gatewaysResults.throwable!!
                    )
                }

                _gatewaysUiState.value = MainPaymentGatewaysUiState(
                    response = paymentGatewayUiStateResult
                )
            }
        }
    }
}