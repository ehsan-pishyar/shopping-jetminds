package com.example.login

import com.example.domain.models.user.UserTokenResponse

sealed interface UserTokenUiState {
    object Loading: UserTokenUiState
    data class Success(val token: UserTokenResponse): UserTokenUiState
    data class Error(val throwable: Throwable): UserTokenUiState
}

data class MainUserTokenUiState(
    val response: UserTokenUiState
)