package com.example.repository.di

import com.example.domain.repositories.ProductShippingClassesRepository
import com.example.domain.use_cases.product_shipping_classes.GetProductShippingClassesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductShippingClassesUseCaseModule {

    @Provides
    fun providesGetProductShippingClassesUseCase(
        repository: ProductShippingClassesRepository
    ): GetProductShippingClassesUseCase = GetProductShippingClassesUseCase(repository)
}