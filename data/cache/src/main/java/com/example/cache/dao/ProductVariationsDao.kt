package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.models.ProductCategoriesResponseEntity
import com.example.cache.models.ProductVariationsResponseEntity

@Dao
interface ProductVariationsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductVariations(variations: List<ProductVariationsResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductVariationDetails(variationDetails: ProductVariationsResponseEntity)

    @Query("SELECT * FROM `product_variations_table` WHERE id = :productId")
    suspend fun fetchProductVariations(productId: Int): List<ProductVariationsResponseEntity>

    @Query("SELECT * FROM `product_variations_table` WHERE id = :variationId")
    suspend fun fetchProductVariationsDetails(variationId: Int): ProductVariationsResponseEntity

    @Query("SELECT COUNT(*) FROM `product_variations_table`")
    suspend fun isProductVariationsCacheAvailable(): Int
}