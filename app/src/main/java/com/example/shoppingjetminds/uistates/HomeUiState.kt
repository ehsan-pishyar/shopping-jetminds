package com.example.shoppingjetminds.uistates

import com.example.domain.models.ProductsResponse

data class HomeUiState(
    val applicationUiKitUiState: ApplicationUiKitUiState,
    val androidUiState: AndroidUiState,
    val illustrations3DUiState: Illustrations3DUiState,
    val isRefreshing: Boolean,
    val isError: Boolean
)

sealed interface ApplicationUiKitUiState {
    data class Success(val applicationUiKits: List<ProductsResponse>): ApplicationUiKitUiState
    data class Error(val message: Throwable? = null): ApplicationUiKitUiState
    object Loading: ApplicationUiKitUiState
}

sealed interface AndroidUiState {
    data class Success(val androidSourceCodes: List<ProductsResponse>): AndroidUiState
    data class Error(val message: Throwable? = null): AndroidUiState
    object Loading: AndroidUiState
}

sealed interface Illustrations3DUiState {
    data class Success(val illustration3Ds: List<ProductsResponse>): Illustrations3DUiState
    data class Error(val message: Throwable? = null): Illustrations3DUiState
    object Loading: Illustrations3DUiState
}