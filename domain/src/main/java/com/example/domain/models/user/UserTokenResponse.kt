package com.example.domain.models.user


data class UserTokenResponse(
    val tokenType: String?,
    val iat: Int?,
    val expiresIn: Int?,
    val jwtToken: String?
)