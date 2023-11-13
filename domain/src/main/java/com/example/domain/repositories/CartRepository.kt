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