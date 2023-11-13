/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 7/31/23, 11:20 PM
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
import androidx.room.Transaction
import com.example.cache.models.ProductVariationsResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductVariationsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreProductVariations(variations: List<ProductVariationsResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProductVariationDetails(variationDetails: ProductVariationsResponseEntity)

    @Query("SELECT * FROM `product_variations_table` WHERE id = :productId")
    fun fetchProductVariations(productId: Int): Flow<List<ProductVariationsResponseEntity>>

//    @Query("SELECT * FROM `product_variations_table` WHERE id = :productId")
//    fun fetchProductVariationsDetails(productId: Int, variationId: Int): Flow<ProductVariationsResponseEntity>

    @Query("DELETE FROM `product_variations_table`")
    suspend fun deleteProductVariations()

    @Transaction
    suspend fun deleteAndInsertProductVariations(variations: List<ProductVariationsResponseEntity>) {
        deleteProductVariations()
        insertOrIgnoreProductVariations(variations)
    }
}