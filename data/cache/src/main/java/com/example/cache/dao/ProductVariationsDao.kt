package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cache.models.ProductVariationsResponseEntity

@Dao
interface ProductVariationsDao {

    @Query("SELECT * FROM `product_variations_table`")
    suspend fun fetchProductVariations(): List<ProductVariationsResponseEntity>
}