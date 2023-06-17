package com.example.repository.di

import com.example.domain.repositories.ProductTagsRepository
import com.example.domain.use_cases.product_tags.GetProductTagDetailsUseCase
import com.example.domain.use_cases.product_tags.GetProductTagsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductTagsUseCaseModule {

    @[Provides Singleton]
    fun providesGetProductTagsUseCase(
        repository: ProductTagsRepository
    ): GetProductTagsUseCase = GetProductTagsUseCase(repository)

    @[Provides Singleton]
    fun providesGetProductTagDetailsUseCase(
        repository: ProductTagsRepository
    ): GetProductTagDetailsUseCase = GetProductTagDetailsUseCase(repository)
}