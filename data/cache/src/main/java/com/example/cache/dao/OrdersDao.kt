package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.cache.models.OrdersResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface OrdersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreOrders(orders: List<OrdersResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrderDetails(orderDetails: OrdersResponseEntity)

    @Query("SELECT * FROM `orders_table`")
    fun fetchOrders(): Flow<List<OrdersResponseEntity>>

    @Query("SELECT * FROM `orders_table` WHERE id = :orderId")
    fun fetchOrderDetails(orderId: Int): Flow<OrdersResponseEntity>

    @Query("DELETE FROM `orders_table`")
    suspend fun deleteOrders()

    @Transaction
    suspend fun deleteAndInsertOrders(orders: List<OrdersResponseEntity>) {
        deleteOrders()
        insertOrIgnoreOrders(orders)
    }
}