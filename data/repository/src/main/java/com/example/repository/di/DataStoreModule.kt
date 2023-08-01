package com.example.repository.di

import com.example.domain.data_store.SplashDataStoreRepository
import com.example.repository.data_store.SplashDataStoreRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataStoreModule {

    @Binds
    @Singleton
    fun bindsSplashDataStoreRepository(
        impl: SplashDataStoreRepositoryImpl
    ): SplashDataStoreRepository
}