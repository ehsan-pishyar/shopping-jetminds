package com.example.cache.di

import android.content.Context
import androidx.room.Room
import com.example.cache.AppDatabase
import com.example.cache.dao.*
import com.example.cache.utils.CacheConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @[Provides Singleton]
    fun providesAppDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            CacheConstants.DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
}