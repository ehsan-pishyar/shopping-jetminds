package com.example.usecases

import com.example.domain.repositories.ProductAttributesRepository
import com.example.domain.use_cases.product_attrs.GetProductAttrDetailsUseCase
import com.example.domain.use_cases.product_attrs.GetProductAttrsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductAttrsUseCaseModule {

    @Provides
    fun providesGetProductAttrsUseCase(
        repository: ProductAttributesRepository
    ): GetProductAttrsUseCase = GetProductAttrsUseCase(repository)

    @Provides
    fun providesGetProductAttrDetailsUseCase(
        repository: ProductAttributesRepository
    ): GetProductAttrDetailsUseCase = GetProductAttrDetailsUseCase(repository)
}