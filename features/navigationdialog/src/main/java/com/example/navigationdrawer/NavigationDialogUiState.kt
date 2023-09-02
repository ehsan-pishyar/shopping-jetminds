package com.example.navigationdrawer

sealed interface NavigationDialogOrdersUiState {
    object Loading: NavigationDialogOrdersUiState
    data class Success(val size: Int): NavigationDialogOrdersUiState
    data class Error(val throwable: Throwable): NavigationDialogOrdersUiState
}

data class MainNavigationDialogOrdersUiState(
    val response: NavigationDialogOrdersUiState
)

sealed interface NavigationDialogCouponsUiState {
    object Loading: NavigationDialogCouponsUiState
    data class Success(val size: Int): NavigationDialogCouponsUiState
    data class Error(val throwable: Throwable): NavigationDialogCouponsUiState
}

data class MainNavigationDialogCouponsUiState(
    val response: NavigationDialogCouponsUiState
)