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