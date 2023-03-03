package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.models.ProductCategoriesResponseEntity
import com.example.cache.models.ProductTagsResponseEntity

@Dao
interface ProductTagsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductTags(tags: List<ProductTagsResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductTagDetails(tagDetails: ProductTagsResponseEntity)

    @Query("SELECT * FROM `product_tags_table`")
    suspend fun fetchProductTags(): List<ProductTagsResponseEntity>

    @Query("SELECT * FROM `product_tags_table` WHERE id = :tagId")
    suspend fun fetchProductTagDetails(tagId: Int): ProductTagsResponseEntity

    @Query("SELECT COUNT(*) FROM `product_tags_table`")
    suspend fun isProductTagsCacheAvailable(): Int
}