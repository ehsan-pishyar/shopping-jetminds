/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/29/23, 1:12 AM
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
import androidx.room.Query
import com.example.cache.models.ProductsResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoritesDao {

    @Query(
        """
            SELECT * FROM `products_table`
            WHERE is_favorite = :isFavorite
        """
    )
    fun fetchFavoriteProducts(
        isFavorite: Boolean = true
    ): Flow<List<ProductsResponseEntity>>

    @Query("UPDATE `products_table` SET is_favorite = :isFavorite WHERE id = :id")
    suspend fun updateIsFavoriteProduct(id: Int, isFavorite: Boolean)

    @Query("SELECT is_favorite FROM `products_table` WHERE id = :productId AND is_favorite = :isFavorite")
    fun isFavoriteProduct(productId: Int, isFavorite: Boolean = true): Flow<Boolean?>
}