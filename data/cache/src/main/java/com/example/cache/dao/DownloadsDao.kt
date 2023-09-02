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