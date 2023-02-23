package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cache.models.ProductAttributesResponseEntity

@Dao
interface ProductAttributesDao {

    @Query("SELECT * FROM `product_attrs_table`")
    suspend fun fetchProductAttrs(): List<ProductAttributesResponseEntity>
}