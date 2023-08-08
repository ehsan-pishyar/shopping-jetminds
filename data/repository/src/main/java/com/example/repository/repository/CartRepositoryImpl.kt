package com.example.repository.repository

import com.example.cache.dao.CartDao
import com.example.domain.models.Cart
import com.example.domain.repositories.CartRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val dao: CartDao
): CartRepository {

    override suspend fun insertItem(item: Cart) {
        TODO("Not yet implemented")
    }

    override fun fetchItems(): Flow<List<Cart>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteItem(itemId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun clearCart() {
        TODO("Not yet implemented")
    }
}