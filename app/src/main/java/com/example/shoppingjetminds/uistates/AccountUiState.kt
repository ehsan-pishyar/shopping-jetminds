package com.example.shoppingjetminds.uistates

sealed interface AccountUiState {
    object Loading: AccountUiState
    data class Success(val user: String /* use UserResponse */ ): AccountUiState
    data class Error(val throwable: Throwable): AccountUiState
}

data class MainAccountUiState(
    val accountUiState: AccountUiState
)