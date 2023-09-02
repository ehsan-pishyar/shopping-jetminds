package com.example.repository.di

import com.example.domain.repositories.DownloadsRepository
import com.example.domain.use_cases.downloads.GetDownloadedProductsUseCase
import com.example.domain.use_cases.downloads.UpdateDownloadedProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DownloadsUseCaseModule {

    @Provides
    fun providesGetDownloadedProductsUseCase(
        repository: DownloadsRepository
    ): GetDownloadedProductsUseCase = GetDownloadedProductsUseCase(repository = repository)

    @Provides
    fun providesUpdateDownloadedProductUseCase(
        repository: DownloadsRepository
    ): UpdateDownloadedProductsUseCase = UpdateDownloadedProductsUseCase(repository = repository)
}