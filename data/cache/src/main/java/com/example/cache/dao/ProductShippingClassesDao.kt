package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.cache.models.ProductShippingClassesResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductShippingClassesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrIgnoreProductShippingClasses(productShippingClasses: List<ProductShippingClassesResponseEntity>)

    @Query("SELECT * FROM `product_shipping_classes_table`")
    fun fetchProductShippingClasses(): Flow<List<ProductShippingClassesResponseEntity>>

    @Query("DELETE FROM `product_shipping_classes_table`")
    suspend fun deleteProductShippingClasses()

    @Transaction
    suspend fun deleteAndInsertProductShippingClasses(productShippingClasses: List<ProductShippingClassesResponseEntity>) {
        deleteProductShippingClasses()
        insertOrIgnoreProductShippingClasses(productShippingClasses)
    }
}