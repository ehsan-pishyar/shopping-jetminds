package com.example.domain.repositories

import com.example.domain.models.Cart
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    suspend fun insertItem(cartItem: Cart)
    suspend fun updateItem(productId: Int, count: Int, newPrice: Int)

    fun getItems(): Flow<List<Cart>>
    fun getSubTotal(): Flow<Int?>
    fun getTotalCounts(): Flow<Int?>
    fun getItemCount(productId: Int): Flow<Int?>
    fun isInCart(productId: Int): Flow<Int?>

    suspend fun deleteItem(productId: Int)
//    suspend fun clearCart()
}