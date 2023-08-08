package com.example.domain.models

data class Cart(
    val cartId: Int?,
    val count: Int?,
    val items: List<ProductsResponse>
)