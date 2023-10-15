package com.example.domain.data_store

import com.example.domain.models.user.UserCredentials
import kotlinx.coroutines.flow.Flow

interface UserDataStoreRepository {

    suspend fun saveUserCredentials(userCredentials: UserCredentials)
    fun readUserCredentials(): Flow<UserCredentials>

    suspend fun saveUserToken(token: String)
    fun readUserToken(): Flow<String>
}