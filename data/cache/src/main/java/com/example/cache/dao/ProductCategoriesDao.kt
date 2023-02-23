package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cache.models.ProductCategoriesResponseEntity

@Dao
interface ProductCategoriesDao {

    @Query("SELECT * FROM `product_categories_table`")
    suspend fun fetchProductCategories(): List<ProductCategoriesResponseEntity>
}