/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/28/23, 9:45 PM
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

import androidx.room.*
import com.example.cache.models.ProductCategoriesResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductCategoriesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreCategories(categories: List<ProductCategoriesResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProductCategoryDetails(categoryDetails: ProductCategoriesResponseEntity)

    @Query("SELECT id, name, image, count FROM `product_categories_table`")
    fun fetchProductCategories(): Flow<List<ProductCategoriesResponseEntity>>

    @Query("SELECT * FROM `product_categories_table` WHERE id = :categoryId")
    fun fetchProductCategoryDetails(categoryId: Int): Flow<ProductCategoriesResponseEntity>

    @Query("DELETE FROM `product_categories_table`")
    suspend fun deleteCategories()

    @Transaction
    suspend fun deleteAndInsertCategories(categories: List<ProductCategoriesResponseEntity>) {
        deleteCategories()
        insertOrIgnoreCategories(categories = categories)
    }
}