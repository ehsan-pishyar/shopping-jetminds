package com.example.repository.di

import com.example.domain.repositories.FavoritesRepository
import com.example.domain.use_cases.favorites.GetFavoriteProductsUseCase
import com.example.domain.use_cases.favorites.UpdateFavoriteProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FavoritesUseCaseModule {

    @Provides
    fun providesGetFavoriteProductsUseCase(
        repository: FavoritesRepository
    ): GetFavoriteProductsUseCase = GetFavoriteProductsUseCase(repository = repository)

    @Provides
    fun providesUpdateFavoriteProductUseCase(
        repository: FavoritesRepository
    ): UpdateFavoriteProductUseCase = UpdateFavoriteProductUseCase(repository = repository)
}