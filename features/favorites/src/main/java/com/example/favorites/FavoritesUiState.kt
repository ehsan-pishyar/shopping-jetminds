package com.example.favorites

import com.example.domain.models.ProductsResponse

data class MainFavoritesUiState(
    val favorites: List<ProductsResponse>
)