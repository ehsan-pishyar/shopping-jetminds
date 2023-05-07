package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.cache.models.ProductAttributesResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductAttributesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreProductAttributes(attrs: List<ProductAttributesResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProductAttrDetails(attrDetails: ProductAttributesResponseEntity)

    @Query("SELECT * FROM `product_attrs_table`")
    fun fetchProductAttrs(): Flow<List<ProductAttributesResponseEntity>>

    @Query("SELECT * FROM `product_attrs_table` WHERE id = :attrId")
    fun fetchProductAttrDetails(attrId: Int): Flow<ProductAttributesResponseEntity>

    @Query("DELETE FROM `product_attrs_table`")
    suspend fun deleteProductAttrs()

    @Transaction
    suspend fun deleteAndInsertProductAttributes(attrs: List<ProductAttributesResponseEntity>) {
        deleteProductAttrs()
        insertOrIgnoreProductAttributes(attrs)
    }
}