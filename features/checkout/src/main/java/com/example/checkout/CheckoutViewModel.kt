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