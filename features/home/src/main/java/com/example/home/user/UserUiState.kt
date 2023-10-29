package com.example.home.user

import com.example.domain.models.user.UserResponse

sealed interface UserUiState {
    object Loading: UserUiState
    data class Success(val user: UserResponse): UserUiState
    data class Error(val throwable: Throwable): UserUiState
}

data class MainUserUiState(
    val response: UserUiState
)