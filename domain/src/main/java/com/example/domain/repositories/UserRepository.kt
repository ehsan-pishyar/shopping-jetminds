package com.example.domain.repositories

import com.example.domain.models.user.TokenValidationResponse
import com.example.domain.models.user.UserCredentials
import com.example.domain.models.user.UserResponse
import com.example.domain.models.user.UserTokenResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUserToken(userCredentials: UserCredentials): Flow<UserTokenResponse>
    fun validateUserToken(): Flow<TokenValidationResponse>
    fun getUser(token: String): Flow<UserResponse>
}