package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.models.ProductCategoriesResponseEntity
import com.example.cache.models.ProductsResponseEntity

@Dao
interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductsResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductsDetails(productDetails: ProductsResponseEntity)

    @Query("SELECT * FROM `products_table`")
    suspend fun fetchProducts(): List<ProductsResponseEntity>

    @Query("SELECT * FROM `products_table` WHERE id = :productId")
    suspend fun fetchProductDetails(productId: Int): ProductsResponseEntity

    @Query("SELECT * FROM `products_table` WHERE categories = :categoryId")
    suspend fun fetchProductsByCategoryId(categoryId: Int): List<ProductsResponseEntity>

    @Query("SELECT * FROM `products_table` WHERE tags = :tagId")
    suspend fun fetchProductsByTagId(tagId: Int): List<ProductsResponseEntity>

    @Query("SELECT * FROM `products_table` WHERE tags = :attrId")
    suspend fun fetchProductsByAttrId(attrId: Int): List<ProductsResponseEntity>

    @Query("SELECT COUNT(*) FROM `products_table`")
    suspend fun isProductsCacheAvailable(): Int
}