package com.example.repository.mappers

import com.example.domain.models.user.AvatarUrls
import com.example.domain.models.user.TokenValidationResponse
import com.example.domain.models.user.UserResponse
import com.example.domain.models.user.UserTokenResponse
import com.example.wordpress_network.models.AvatarUrlsDto
import com.example.wordpress_network.models.TokenValidationResponseDto
import com.example.wordpress_network.models.UserResponseDto
import com.example.wordpress_network.models.UserTokenResponseDto

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