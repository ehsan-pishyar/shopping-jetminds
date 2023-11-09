package com.example.login

import com.example.domain.models.user.UserResponse

sealed interface WordpressUserUiState {
    object Loading: WordpressUserUiState
    data class Success (val wordpressUser: UserResponse): WordpressUserUiState
    data class Error (val throwable: Throwable): WordpressUserUiState
}

data class MainWordpressUserUiState(
    val response: WordpressUserUiState
)