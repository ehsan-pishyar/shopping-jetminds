package com.example.repository.repository.wordpress

import com.example.domain.models.user.TokenValidationResponse
import com.example.domain.models.user.UserCredentials
import com.example.domain.models.user.UserResponse
import com.example.domain.models.user.UserTokenResponse
import com.example.domain.repositories.UserRepository
import com.example.network.UserApiService
import com.example.network.UserTokenApiService
import com.example.repository.mappers.toDomain
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

    override fun validateUserToken(): Flow<TokenValidationResponse> = flow {
        emit(userApi.checkToken().toDomain().also {
            println("*** Repository Validation result: ${it.status}")
        })
    }

    override fun getUser(token: String): Flow<UserResponse> = flow {
        userApi.getUser(token = token).toDomain().also {
            println("*** DTO - User Response ${it.name}")
        }
    }
}