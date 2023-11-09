package com.example.login.customer

import com.example.domain.models.CustomersResponse

sealed interface CustomerUiState {
    object Loading: CustomerUiState
    data class Success(val customer: CustomersResponse): CustomerUiState
    data class Error(val throwable: Throwable): CustomerUiState
}

data class MainCustomerUiState(
    val response: CustomerUiState
)