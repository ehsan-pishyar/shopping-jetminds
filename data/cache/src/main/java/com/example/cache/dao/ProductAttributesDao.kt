package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.models.CouponsResponseEntity
import com.example.cache.models.ProductAttributesResponseEntity
import com.example.cache.models.ProductCategoriesResponseEntity

@Dao
interface ProductAttributesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductAttributes(attrs: List<ProductAttributesResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProductAttrDetails(attrDetails: ProductAttributesResponseEntity)

    @Query("SELECT * FROM `product_attrs_table`")
    suspend fun fetchProductAttrs(): List<ProductAttributesResponseEntity>

    @Query("SELECT * FROM `product_attrs_table` WHERE id = :attrId")
    suspend fun fetchProductAttrDetails(attrId: Int): ProductAttributesResponseEntity

    @Query("SELECT COUNT(*) FROM `product_attrs_table`")
    suspend fun isProductAttributesCacheAvailable(): Int
}