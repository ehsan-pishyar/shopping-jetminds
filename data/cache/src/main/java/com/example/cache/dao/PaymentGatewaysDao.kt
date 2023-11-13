/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/15/23, 11:41 PM
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
import com.example.cache.models.PaymentGatewaysResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PaymentGatewaysDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPaymentGateway(gateways: List<PaymentGatewaysResponseEntity>)

    @Query("SELECT * FROM `payment_gateways_table` WHERE enabled = :enabled")
    fun fetchPaymentGateways(enabled: Boolean = true): Flow<List<PaymentGatewaysResponseEntity>>

    @Query("SELECT * FROM `payment_gateways_table` WHERE id = :gatewayId")
    fun fetchPaymentGatewayDetails(gatewayId: String): Flow<PaymentGatewaysResponseEntity>

    @Query("DELETE FROM `payment_gateways_table`")
    suspend fun clearPaymentGateways()

    @Transaction
    suspend fun deleteAndInsertPaymentGateways(gateways: List<PaymentGatewaysResponseEntity>) {
        clearPaymentGateways()
        insertPaymentGateway(gateways = gateways)
    }
}