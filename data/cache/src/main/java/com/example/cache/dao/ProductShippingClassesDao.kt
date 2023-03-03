package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.models.ProductCategoriesResponseEntity
import com.example.cache.models.ProductShippingClassesResponseEntity

@Dao
interface ProductShippingClassesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductShippingClasses(productShippingClasses: List<ProductShippingClassesResponseEntity>)

    @Query("SELECT * FROM `product_shipping_classes_table`")
    suspend fun fetchProductShippingClasses(): List<ProductShippingClassesResponseEntity>

    @Query("SELECT COUNT(*) FROM `product_shipping_classes_table`")
    suspend fun isProductShippingClassesCacheAvailable(): Int
}