package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.models.ProductCategoriesResponseEntity

@Dao
interface ProductCategoriesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductCategoriesToDb(categories: List<ProductCategoriesResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductCategoryDetails(categoryDetails: ProductCategoriesResponseEntity)

    @Query("SELECT * FROM `product_categories_table`")
    suspend fun fetchProductCategories(): List<ProductCategoriesResponseEntity>

    @Query("SELECT * FROM `product_categories_table` WHERE id = :categoryId")
    suspend fun fetchProductCategoryDetails(categoryId: Int): ProductCategoriesResponseEntity

    @Query("SELECT COUNT(*) FROM `product_categories_table`")
    suspend fun isProductCategoryCacheAvailable(): Int
}