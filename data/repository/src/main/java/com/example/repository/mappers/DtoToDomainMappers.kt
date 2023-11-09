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