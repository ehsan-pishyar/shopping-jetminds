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
    suspend fun insertOrIgnoreCustomers(customers: List<CustomersResponseEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrIgnoreCustomerDetails(customer: CustomersResponseEntity)

    @Query("SELECT * FROM `customers_table`")
    fun fetchCustomers(): Flow<List<CustomersResponseEntity>>

    @Query("SELECT * FROM `customers_table` WHERE id = :customerId")
    fun fetchCustomerDetails(customerId: Int): Flow<CustomersResponseEntity>

    @Query("DELETE FROM `customers_table`")
    suspend fun deleteCustomers()

    @Transaction
    suspend fun deleteAndInsertCustomers(customers: List<CustomersResponseEntity>) {
        deleteCustomers()
        insertOrIgnoreCustomers(customers)
    }
}