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
    suspend fun insertItem(cartItem: CartEntity)

    @Query("UPDATE `cart_table` SET item_count = :count, product_price = :newPrice WHERE product_id = :productId")
    suspend fun updateItem(productId: Int, count: Int, newPrice: Int)

    @Query("SELECT * FROM `cart_table` ORDER BY date_added DESC")
    fun fetchItems(): Flow<List<CartEntity>>

    @Query("SELECT SUM(product_price) AS sub_total_price FROM `cart_table`")
    fun fetchTotalPrices(): Flow<Int?>

    @Query("SELECT COUNT(*) FROM `cart_table`")
    fun fetchTotalCount(): Flow<Int?>

    @Query("SELECT item_count FROM `cart_table` WHERE product_id = :productId")
    fun fetchItemCount(productId: Int): Flow<Int?>

    @Query("SELECT COUNT(*) FROM `cart_table` WHERE product_id = :productId")
    fun isInCart(productId: Int): Flow<Int?>

    @Query("DELETE FROM `cart_table` WHERE product_id = :productId")
    suspend fun deleteItem(productId: Int)
}