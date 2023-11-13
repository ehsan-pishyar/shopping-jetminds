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

package com.example.repository.mappers

import com.example.domain.models.user.AvatarUrls
import com.example.domain.models.user.TokenValidationResponse
import com.example.domain.models.user.UserResponse
import com.example.domain.models.user.UserTokenResponse
import com.example.network.models.wordpress.AvatarUrlsDto
import com.example.network.models.wordpress.TokenValidationResponseDto
import com.example.network.models.wordpress.UserResponseDto
import com.example.network.models.wordpress.UserTokenResponseDto

fun UserResponseDto.toDomain(): UserResponse =
    UserResponse(
        this.id,
        this.name,
        this.url,
        this.description,
        this.link,
        this.slug,
        this.avatarUrls?.toDomain(),
        this.isSuperAdmin
    )

fun AvatarUrlsDto.toDomain(): AvatarUrls =
    AvatarUrls(
        this.size24,
        this.size48,
        this.size96
    )

fun UserTokenResponseDto.toDomain(): UserTokenResponse =
    UserTokenResponse(
        this.tokenType,
        this.iat,
        this.expiresIn,
        this.jwtToken
    )

fun TokenValidationResponseDto.toDomain(): TokenValidationResponse =
    TokenValidationResponse(
        this.status,
        this.message,
        this.code
    )