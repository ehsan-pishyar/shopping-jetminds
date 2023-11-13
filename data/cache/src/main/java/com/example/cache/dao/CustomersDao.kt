/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 9/5/23, 3:16 PM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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