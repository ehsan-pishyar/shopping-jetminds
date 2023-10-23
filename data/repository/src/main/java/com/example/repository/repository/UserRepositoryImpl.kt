package com.example.repository.repository

import com.example.domain.models.user.TokenValidationResponse
import com.example.domain.models.user.UserCredentials
import com.example.domain.models.user.UserResponse
import com.example.domain.models.user.UserTokenResponse
import com.example.domain.repositories.UserRepository
import com.example.repository.mappers.toDomain
import com.example.wordpress_network.UserApiService
import com.example.wordpress_network.UserTokenApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApiService,
    private val tokenApi: UserTokenApiService
): UserRepository {

    override fun getUserToken(userCredentials: UserCredentials): Flow<UserTokenResponse> = flow {
        emit(tokenApi.getUserToken(
            username = userCredentials.username,
            password = userCredentials.password
        ).toDomain())
    }

    override fun validateUserToken(headers: Map<String, String>): Flow<TokenValidationResponse> = flow {
        emit(userApi.checkToken(headers = headers).toDomain())
    }

    override fun getUser(headers: Map<String, String>): Flow<UserResponse> = flow {
        userApi.getUser(headers = headers).toDomain()
    }
}