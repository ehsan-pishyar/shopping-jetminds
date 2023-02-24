package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cache.models.ProductsResponseEntity

@Dao
interface ProductsDao {

    @Query("SELECT * FROM `products_table`")
    suspend fun fetchProducts(): List<ProductsResponseEntity>

    @Query("SELECT * FROM `products_table` WHERE id = :productId")
    suspend fun fetchProductDetails(productId: Int): ProductsResponseEntity

    @Query("SELECT * FROM `products_table` WHERE categories = :categoryId")
    suspend fun fetchProductsByCategoryId(categoryId: Int): List<ProductsResponseEntity>

    @Query("SELECT * FROM `products_table` WHERE tags = :tagId")
    suspend fun fetchProductsByTagId(tagId: Int): List<ProductsResponseEntity>
}