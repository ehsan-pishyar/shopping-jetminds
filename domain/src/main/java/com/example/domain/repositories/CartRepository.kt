package com.example.domain.repositories

import com.example.domain.models.ProductsResponse
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    fun fetchItems(): Flow<List<ProductsResponse>>
    suspend fun updateInCartProduct(productId: Int, inCart: Boolean, addedToCartDate: String)
    fun isInCart(productId: Int): Flow<Boolean?>
    fun itemCountInCart(): Flow<Int?>
}