package com.example.cart

import com.example.domain.models.ProductsResponse

data class MainCartUiState(
    val cartUiState: List<ProductsResponse>
)