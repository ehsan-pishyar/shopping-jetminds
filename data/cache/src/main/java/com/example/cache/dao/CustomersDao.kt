package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.cache.models.CustomersResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CustomersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreCustomer(customer: CustomersResponseEntity)

    @Query("SELECT * FROM `customers_table` WHERE id = :customerId")
    fun fetchCustomer(
        customerId: Int
    ): Flow<CustomersResponseEntity>

    @Query("DELETE FROM `customers_table`")
    suspend fun deleteCustomers()

    @Transaction
    suspend fun deleteAndInsertCustomers(customer: CustomersResponseEntity) {
        deleteCustomers()
        insertOrIgnoreCustomer(customer = customer)
    }
}