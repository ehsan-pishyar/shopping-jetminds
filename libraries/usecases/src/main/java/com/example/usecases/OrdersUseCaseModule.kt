package com.example.usecases

import com.example.domain.repositories.OrdersRepository
import com.example.domain.use_cases.orders.GetOrderDetailsUseCase
import com.example.domain.use_cases.orders.GetOrdersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object OrdersUseCaseModule {

    @Provides
    fun providesGetOrdersUseCase(
        repository: OrdersRepository
    ): GetOrdersUseCase = GetOrdersUseCase(repository)

    @Provides
    fun providesGetOrderDetailsUseCase(
        repository: OrdersRepository
    ): GetOrderDetailsUseCase = GetOrderDetailsUseCase(repository)
}