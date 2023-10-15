package com.example.checkout

import com.example.domain.models.PaymentGatewaysResponse

sealed interface PaymentGatewaysUiState {
    object Loading: PaymentGatewaysUiState
    data class Success(val gateways: List<PaymentGatewaysResponse>): PaymentGatewaysUiState
    data class Error(val throwable: Throwable): PaymentGatewaysUiState
}

data class MainPaymentGatewaysUiState(
    val response: PaymentGatewaysUiState
)