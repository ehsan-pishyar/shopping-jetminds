package com.example.domain.data_store

import kotlinx.coroutines.flow.Flow

interface SplashDataStoreRepository {

    suspend fun saveOnBoardingState(completed: Boolean)
    fun readOnBoardingState(): Flow<Boolean>
}