package com.example.datastore.di

import com.example.datastore.SplashDataStoreRepositoryImpl
import com.example.datastore.UserDataStoreRepositoryImpl
import com.example.domain.data_store.SplashDataStoreRepository
import com.example.domain.data_store.UserDataStoreRepository
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

    @Binds
    @Singleton
    fun bindsUserDataStoreRepository(
        impl: UserDataStoreRepositoryImpl
    ): UserDataStoreRepository
}