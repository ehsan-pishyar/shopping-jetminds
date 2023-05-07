package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.cache.models.ProductVariationsResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductVariationsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreProductVariations(variations: List<ProductVariationsResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProductVariationDetails(variationDetails: ProductVariationsResponseEntity)

    @Query("SELECT * FROM `product_variations_table` WHERE id = :productId")
    fun fetchProductVariations(productId: Int): Flow<List<ProductVariationsResponseEntity>>

    @Query("SELECT * FROM `product_variations_table` WHERE id = :variationId")
    fun fetchProductVariationsDetails(variationId: Int): Flow<ProductVariationsResponseEntity>

    @Query("DELETE FROM `product_variations_table`")
    suspend fun deleteProductVariations()

    @Transaction
    suspend fun deleteAndInsertProductVariations(variations: List<ProductVariationsResponseEntity>) {
        deleteProductVariations()
        insertOrIgnoreProductVariations(variations)
    }
}