package com.example.shop

import com.example.domain.models.ProductsResponse

sealed interface ShopProductsUiState {
    object Loading: ShopProductsUiState
    data class Success(val products: List<ProductsResponse>): ShopProductsUiState
    data class Error(val throwable: Throwable): ShopProductsUiState
}

data class MainShopProductsUiState(
    val shopProductsUiState: ShopProductsUiState
)