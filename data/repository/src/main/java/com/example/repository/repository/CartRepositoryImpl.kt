package com.example.repository.repository

import com.example.cache.dao.CartDao
import com.example.cache.models.CartEntity
import com.example.domain.models.Cart
import com.example.domain.repositories.CartRepository
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val dao: CartDao
): CartRepository {

    override suspend fun insertItem(item: Cart) {
        dao.insertItem(item = item.toEntity())
    }

    override fun fetchItems(): Flow<List<Cart>> {
        return dao.fetchItems().map { cartItems ->
            cartItems.map(CartEntity::toDomain)
        }
    }

    override suspend fun deleteItem() {
        dao.deleteItem()
    }

    override suspend fun clearCart() {
        dao.clearCart()
    }
}