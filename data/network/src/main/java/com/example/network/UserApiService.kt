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