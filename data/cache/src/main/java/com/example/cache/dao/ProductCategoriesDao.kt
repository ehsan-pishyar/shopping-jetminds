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