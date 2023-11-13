/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/11/23, 12:42 PM
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

package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.models.CartEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(cartItem: CartEntity)

    @Query("UPDATE `cart_table` SET item_count = :count, product_price = :newPrice WHERE product_id = :productId")
    suspend fun updateItem(productId: Int, count: Int, newPrice: Int)

    @Query("SELECT * FROM `cart_table` ORDER BY date_added DESC")
    fun fetchItems(): Flow<List<CartEntity>>

    @Query("SELECT SUM(product_price) AS sub_total_price FROM `cart_table`")
    fun fetchTotalPrices(): Flow<Int?>

    @Query("SELECT COUNT(*) FROM `cart_table`")
    fun fetchTotalCount(): Flow<Int?>

    @Query("SELECT item_count FROM `cart_table` WHERE product_id = :productId")
    fun fetchItemCount(productId: Int): Flow<Int?>

    @Query("SELECT COUNT(*) FROM `cart_table` WHERE product_id = :productId")
    fun isInCart(productId: Int): Flow<Int?>

    @Query("DELETE FROM `cart_table` WHERE product_id = :productId")
    suspend fun deleteItem(productId: Int)
}