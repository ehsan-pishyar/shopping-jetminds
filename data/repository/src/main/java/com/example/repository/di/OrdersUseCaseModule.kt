package com.example.repository.di

import com.example.domain.repositories.OrdersRepository
import com.example.domain.use_cases.orders.GetOrderDetailsUseCase
import com.example.domain.use_cases.orders.GetOrdersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object OrdersUseCaseModule {

    @[Provides Singleton]
    fun providesGetOrdersUseCase(
        repository: OrdersRepository
    ): GetOrdersUseCase = GetOrdersUseCase(repository)

    @[Provides Singleton]
    fun providesGetOrderDetailsUseCase(
        repository: OrdersRepository
    ): GetOrderDetailsUseCase = GetOrderDetailsUseCase(repository)
}