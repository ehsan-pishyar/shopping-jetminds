package com.example.usecases

import com.example.domain.repositories.CustomerRepository
import com.example.domain.use_cases.cutomer.GetCustomerUseCase
import com.example.domain.use_cases.cutomer.InsertCustomerUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object CustomerUseCaseModule {

    @Provides
    fun providesGetCustomerUseCase(
        repository: CustomerRepository
    ): GetCustomerUseCase = GetCustomerUseCase(repository = repository)

    @Provides
    fun providesInsertCustomerUseCase(
        repository: CustomerRepository
    ): InsertCustomerUseCase = InsertCustomerUseCase(repository = repository)
}