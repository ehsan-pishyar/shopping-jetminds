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