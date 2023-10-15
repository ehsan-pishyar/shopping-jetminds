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
        tokenApi.getUserToken(
            username = userCredentials.username,
            password = userCredentials.password
        ).toDomain()
    }
//
//    override fun validateUserToken(): Flow<TokenValidationResponse> = flow {
//        tokenApi.checkToken("").toDomain()
//    }
//
//    override fun getUser(): Flow<UserResponse> = flow {
//        userApi.getUser("").toDomain()
//    }
}