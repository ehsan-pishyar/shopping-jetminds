package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.cache.models.OrdersResponseEntity

@Dao
interface OrdersDao {

    @Query("SELECT * FROM `orders_table`")
    suspend fun fetchOrders(): List<OrdersResponseEntity>

    @Query("SELECT * FROM `orders_table` WHERE id = :orderId")
    suspend fun fetchOrderDetails(orderId: Int): OrdersResponseEntity
}