package com.example.domain.repositories

import com.example.domain.models.Cart
import kotlinx.coroutines.flow.Flow

interface CartRepository {

    suspend fun insertItem(item: Cart)
    fun fetchItems(): Flow<List<Cart>>
    suspend fun deleteItem()
    suspend fun clearCart()
}