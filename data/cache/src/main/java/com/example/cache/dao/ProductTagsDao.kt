/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 5/24/23, 11:56 PM
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
import com.example.cache.models.ProductTagsResponseEntity
import kotlinx.coroutines.flow.Flow

// برچسب محصولات سایت. منظور مثل دسته بندی محصولات، همه برچسب ها رو شامل میشه واسه لیست کردن
@Dao
interface ProductTagsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreProductTags(tags: List<ProductTagsResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProductTagDetails(tagDetails: ProductTagsResponseEntity)

    @Query("SELECT * FROM `product_tags_table`")
    fun fetchProductTags(): Flow<List<ProductTagsResponseEntity>>

    @Query("SELECT * FROM `product_tags_table` WHERE id = :tagId")
    fun fetchProductTagDetails(tagId: Int): Flow<ProductTagsResponseEntity>

    @Query("DELETE FROM `product_tags_table`")
    suspend fun deleteProductTags()

    @Transaction
    suspend fun deleteAndInsertProductTags(tags: List<ProductTagsResponseEntity>) {
        deleteProductTags()
        insertOrIgnoreProductTags(tags)
    }
}