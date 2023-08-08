package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.models.CartEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertItem(item: CartEntity)

    @Query("SELECT * FROM `cart_table`")
    fun fetchItems(): Flow<List<CartEntity>>

    @Query("DELETE FROM `cart_table` WHERE id = :itemId")
    suspend fun deleteItem(itemId: Int)

    @Query("DELETE FROM `cart_table`")
    suspend fun clearCart()

    @Query("SELECT COUNT(*) FROM `cart_table`")
    suspend fun hasItems(): Flow<Int>
}