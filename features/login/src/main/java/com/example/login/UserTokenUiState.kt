package com.example.login

import com.example.domain.models.user.TokenValidationResponse
import com.example.domain.models.user.UserTokenResponse

sealed interface UserTokenUiState {
    object Loading: UserTokenUiState
    data class Success(val userTokenResponse: UserTokenResponse): UserTokenUiState
    data class Error(val throwable: Throwable): UserTokenUiState
}

data class MainUserTokenUiState(
    val response: UserTokenUiState
)

sealed interface ValidateTokenUiState {
    object Loading: ValidateTokenUiState
    data class Success(val status: TokenValidationResponse): ValidateTokenUiState
    data class Error(val throwable: Throwable): ValidateTokenUiState
}

data class MainValidateTokenUiState(
    val response: ValidateTokenUiState
)