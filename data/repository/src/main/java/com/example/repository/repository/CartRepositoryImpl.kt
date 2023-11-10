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

    override suspend fun insertItem(cartItem: Cart) {
        dao.insertItem(cartItem = cartItem.toEntity())
    }

    override suspend fun updateItem(productId: Int, count: Int, newPrice: Int) {
        dao.updateItem(
            productId = productId,
            count = count,
            newPrice = newPrice
        )
    }

    override fun fetchItems(): Flow<List<Cart>> {
        return dao.fetchItems().map { cartItems ->
            cartItems.map(CartEntity::toDomain)
        }
    }

    override fun fetchTotalPrices(): Flow<Int?> {
        return dao.fetchTotalPrices()
    }

    override fun fetchTotalCount(): Flow<Int?> {
        return dao.fetchTotalCount()
    }

    override fun fetchItemCount(productId: Int): Flow<Int?> {
        return dao.fetchItemCount(productId = productId)
    }

    override fun isInCart(productId: Int): Flow<Int?> {
        return dao.isInCart(productId = productId)
    }

    override suspend fun deleteItem(productId: Int) {
        dao.deleteItem(productId = productId)
    }
//
//    override suspend fun clearCart() {
//        dao.clearCart()
//    }
}