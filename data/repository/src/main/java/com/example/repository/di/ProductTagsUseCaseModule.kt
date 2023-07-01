package com.example.repository.di

import com.example.domain.repositories.ProductTagsRepository
import com.example.domain.use_cases.product_tags.GetProductTagDetailsUseCase
import com.example.domain.use_cases.product_tags.GetProductTagsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ProductTagsUseCaseModule {

    @Provides
    fun providesGetProductTagsUseCase(
        repository: ProductTagsRepository
    ): GetProductTagsUseCase = GetProductTagsUseCase(repository)

    @Provides
    fun providesGetProductTagDetailsUseCase(
        repository: ProductTagsRepository
    ): GetProductTagDetailsUseCase = GetProductTagDetailsUseCase(repository)
}