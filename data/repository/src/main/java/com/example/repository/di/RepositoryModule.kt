package com.example.repository.di

import com.example.cache.dao.*
import com.example.domain.repositories.*
import com.example.domain.use_cases.products.*
import com.example.repository.repository.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun productCategoriesRepository(
        productCategoriesRepositoryImpl: ProductCategoriesRepositoryImpl
    ): ProductCategoriesRepository
}