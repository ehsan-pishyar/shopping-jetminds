/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/9/23, 9:21 AM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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