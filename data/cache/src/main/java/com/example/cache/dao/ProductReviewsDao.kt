/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 6/2/23, 9:47 PM
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
import com.example.cache.models.ProductReviewsResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductReviewsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreProductReviews(reviews: List<ProductReviewsResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProductReviewDetails(review: ProductReviewsResponseEntity)

    @Query("SELECT * FROM `product_reviews_table` WHERE product_id = :productId")
    fun fetchProductReviews(productId: Int): Flow<List<ProductReviewsResponseEntity>>

    @Query("SELECT * FROM `product_reviews_table` WHERE id = :reviewId")
    fun fetchProductReviewDetails(reviewId: Int): Flow<ProductReviewsResponseEntity>

    @Query("DELETE FROM `product_reviews_table`")
    suspend fun deleteProductReviews()

    @Transaction
    suspend fun deleteAndInsertProductReviews(reviews: List<ProductReviewsResponseEntity>) {
        deleteProductReviews()
        insertOrIgnoreProductReviews(reviews)
    }
}