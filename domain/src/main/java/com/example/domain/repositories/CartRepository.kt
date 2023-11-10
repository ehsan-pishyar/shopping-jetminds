package com.example.domain.repositories

import com.example.domain.models.Cart
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    suspend fun insertItem(cartItem: Cart)
    suspend fun updateItem(productId: Int, count: Int, newPrice: Int)

    fun fetchItems(): Flow<List<Cart>>
    fun fetchTotalPrices(): Flow<Int?>
    fun fetchTotalCount(): Flow<Int?>
    fun fetchItemCount(productId: Int): Flow<Int?>
    fun isInCart(productId: Int): Flow<Int?>

    suspend fun deleteItem(productId: Int)
//    suspend fun clearCart()
}