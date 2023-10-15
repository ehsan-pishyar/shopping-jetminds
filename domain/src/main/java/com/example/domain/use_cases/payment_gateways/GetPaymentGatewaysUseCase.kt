package com.example.domain.use_cases.payment_gateways

import com.example.domain.models.PaymentGatewaysResponse
import com.example.domain.repositories.PaymentGatewaysRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetPaymentGatewaysUseCase constructor(
    private val repository: PaymentGatewaysRepository
) {

    operator fun invoke(): Flow<ServiceResult<List<PaymentGatewaysResponse>>> =
        repository.getPaymentGateways().asResult()
}