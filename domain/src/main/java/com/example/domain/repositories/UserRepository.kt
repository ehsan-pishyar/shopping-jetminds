/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/6/23, 6:51 PM
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