package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cache.models.ProductShippingClassesResponseEntity

@Dao
interface ProductShippingClassesDao {

    @Query("SELECT * FROM `product_shipping_classes_table`")
    suspend fun fetchProductShippingClasses(): List<ProductShippingClassesResponseEntity>
}