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