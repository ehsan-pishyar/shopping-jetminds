package com.example.domain.models.user

data class TokenValidationResponse(
    val status: String?,
    val message: String?,
    val code: String?
)