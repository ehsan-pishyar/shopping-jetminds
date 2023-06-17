package com.example.repository.di

import com.example.domain.repositories.ProductAttributesRepository
import com.example.domain.use_cases.product_attrs.GetProductAttrDetailsUseCase
import com.example.domain.use_cases.product_attrs.GetProductAttrsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductAttrsUseCaseModule {

    @[Provides Singleton]
    fun providesGetProductAttrsUseCase(
        repository: ProductAttributesRepository
    ): GetProductAttrsUseCase = GetProductAttrsUseCase(repository)

    @[Provides Singleton]
    fun providesGetProductAttrDetailsUseCase(
        repository: ProductAttributesRepository
    ): GetProductAttrDetailsUseCase = GetProductAttrDetailsUseCase(repository)
}