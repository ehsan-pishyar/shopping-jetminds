package com.example.repository.repository

import com.example.cache.dao.CartDao
import com.example.cache.models.ProductsResponseEntity
import com.example.domain.models.ProductsResponse
import com.example.domain.repositories.CartRepository
import com.example.repository.mappers.toDomain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val dao: CartDao
): CartRepository {

    override fun fetchItems(): Flow<List<ProductsResponse>> {
        return dao.fetchItems().map { cartItems ->
            cartItems.map(ProductsResponseEntity::toDomain)
        }
    }

    override suspend fun updateInCartProduct(productId: Int, inCart: Boolean, addedToCartDate: String) {
        dao.updateInCartProduct(
            productId = productId,
            inCart = inCart,
            addedToCartDate = addedToCartDate
        )
    }

    override fun isInCart(productId: Int): Flow<Boolean?> {
        return dao.isInCart(productId = productId).flowOn(Dispatchers.IO)
    }

    override fun itemCountInCart(): Flow<Int?> {
        return dao.itemCountInCart().flowOn(Dispatchers.IO)
    }
}