package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cache.models.ProductTagsResponseEntity

@Dao
interface ProductTagsDao {

    @Query("SELECT * FROM `product_tags_table`")
    suspend fun fetchProductTags(): List<ProductTagsResponseEntity>
}