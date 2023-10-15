package com.example.domain.repositories

import com.example.domain.models.PaymentGatewaysResponse
import kotlinx.coroutines.flow.Flow

interface PaymentGatewaysRepository {

    fun getPaymentGateways(): Flow<List<PaymentGatewaysResponse>>
    fun getPaymentGatewayDetails(gatewayId: String): Flow<PaymentGatewaysResponse>

    suspend fun refreshGateways()
}