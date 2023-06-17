package com.example.repository.di

import com.example.domain.repositories.ProductReviewsRepository
import com.example.domain.use_cases.product_reviews.GetProductReviewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductReviewsUseCaseModule {

    @[Provides Singleton]
    fun providesGetProductReviewsUseCase(
        repository: ProductReviewsRepository
    ): GetProductReviewsUseCase = GetProductReviewsUseCase(repository)
}