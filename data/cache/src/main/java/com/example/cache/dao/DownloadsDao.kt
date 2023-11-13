/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/2/23, 1:30 AM
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
interface DownloadsDao {

    @Query("""
        SELECT * FROM `products_table`
        WHERE downloaded = :downloaded
    """)
    fun fetchDownloadedProducts(
        downloaded: Boolean = true
    ): Flow<List<ProductsResponseEntity>>

    @Query("UPDATE `products_table` SET downloaded = :downloaded WHERE id = :productId")
    suspend fun updateDownloadedProduct(
        productId: Int,
        downloaded: Boolean
    )
}