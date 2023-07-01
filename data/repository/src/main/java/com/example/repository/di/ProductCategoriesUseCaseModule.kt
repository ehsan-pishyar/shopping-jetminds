package com.example.repository.di

import com.example.domain.repositories.ProductCategoriesRepository
import com.example.domain.use_cases.product_categories.GetProductCategoriesUseCase
import com.example.domain.use_cases.product_categories.GetProductCategoryDetailsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductCategoriesUseCaseModule {

    @Provides
    fun providesGetProductCategoriesUseCase(
        repository: ProductCategoriesRepository
    ): GetProductCategoriesUseCase = GetProductCategoriesUseCase(repository)

    @Provides
    fun providesGetProductCategoryDetailsUseCase(
        repository: ProductCategoriesRepository
    ): GetProductCategoryDetailsUseCase = GetProductCategoryDetailsUseCase(repository)
}