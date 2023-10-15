package com.example.usecases

import com.example.domain.repositories.PaymentGatewaysRepository
import com.example.domain.use_cases.payment_gateways.GetPaymentGatewayUseCase
import com.example.domain.use_cases.payment_gateways.GetPaymentGatewaysUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PaymentGatewaysUseCaseModule {

    @Provides
    fun providesGetPaymentGatewaysUseCase(
        repository: PaymentGatewaysRepository
    ): GetPaymentGatewaysUseCase = GetPaymentGatewaysUseCase(repository = repository)

    @Provides
    fun providesGetPaymentGatewayUseCase(
        repository: PaymentGatewaysRepository
    ): GetPaymentGatewayUseCase = GetPaymentGatewayUseCase(repository = repository)
}