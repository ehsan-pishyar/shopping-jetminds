package com.example.repository.di

import com.example.domain.repositories.ProductVariationsRepository
import com.example.domain.use_cases.product_variations.GetProductVariationDetailsUseCase
import com.example.domain.use_cases.product_variations.GetProductVariationsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductVariationsUseCaseModule {

    @[Provides Singleton]
    fun providesGetProductVariationsUseCase(
        repository: ProductVariationsRepository
    ): GetProductVariationsUseCase = GetProductVariationsUseCase(repository)

    @[Provides Singleton]
    fun providesGetProductVariationDetailsUseCase(
        repository: ProductVariationsRepository
    ): GetProductVariationDetailsUseCase = GetProductVariationDetailsUseCase(repository)
}