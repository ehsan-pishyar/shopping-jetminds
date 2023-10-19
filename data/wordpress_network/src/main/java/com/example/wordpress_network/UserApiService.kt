package com.example.wordpress_network

import com.example.wordpress_network.models.TokenValidationResponseDto
import com.example.wordpress_network.models.UserResponseDto
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface UserApiService {

    @GET("users/me")
    suspend fun getUser(
        @HeaderMap headers: Map<String, String>
    ): UserResponseDto

    @GET("token-validate")
    suspend fun checkToken(
        @HeaderMap headers: Map<String, String>
    ): TokenValidationResponseDto
}