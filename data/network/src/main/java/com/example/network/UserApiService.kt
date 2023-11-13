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

package com.example.network

import com.example.network.models.wordpress.TokenValidationResponseDto
import com.example.network.models.wordpress.UserResponseDto
import retrofit2.http.GET
import retrofit2.http.Header

interface UserApiService {

    @GET("users/me")
    suspend fun getUser(
        @Header("Authorization") token: String
    ): UserResponseDto

    @GET("token-validate")
    suspend fun checkToken(): TokenValidationResponseDto
}