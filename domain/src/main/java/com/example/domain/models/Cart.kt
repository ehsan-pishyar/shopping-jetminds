package com.example.domain.models

data class Cart(
    val productId: Int?,
    val productTitle: String?,
    val productImage: String?,
    val productCategory: String?,
    val productPrice: Int?,
    val dateAdded: String?,
    val itemCount: Int?
)