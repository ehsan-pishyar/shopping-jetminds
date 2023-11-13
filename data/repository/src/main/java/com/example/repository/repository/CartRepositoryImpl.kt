/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/11/23, 12:27 PM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

    override fun getItems(): Flow<List<Cart>> {
        return dao.fetchItems().map { cartItems ->
            cartItems.map(CartEntity::toDomain)
        }
    }

    override fun getSubTotal(): Flow<Int?> {
        return dao.fetchTotalPrices()
    }

    override fun getTotalCounts(): Flow<Int?> {
        return dao.fetchTotalCount()
    }

    override fun getItemCount(productId: Int): Flow<Int?> {
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