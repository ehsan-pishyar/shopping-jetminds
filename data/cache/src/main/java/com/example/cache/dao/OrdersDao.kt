package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.models.OrdersResponseEntity
import com.example.cache.models.ProductCategoriesResponseEntity

@Dao
interface OrdersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrders(orders: List<OrdersResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrderDetails(orderDetails: OrdersResponseEntity)

    @Query("SELECT * FROM `orders_table`")
    suspend fun fetchOrders(): List<OrdersResponseEntity>

    @Query("SELECT * FROM `orders_table` WHERE id = :orderId")
    suspend fun fetchOrderDetails(orderId: Int): OrdersResponseEntity

    @Query("SELECT COUNT(*) FROM `orders_table`")
    suspend fun isOrdersCacheAvailable(): Int
}