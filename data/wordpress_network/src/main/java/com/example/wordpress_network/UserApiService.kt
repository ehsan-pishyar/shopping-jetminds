package com.example.wordpress_network

import com.example.wordpress_network.models.UserResponseDto
import retrofit2.http.GET
import retrofit2.http.HeaderMap

interface UserApiService {

    @GET("users/me")
    suspend fun getUser(
        @HeaderMap headers: Map<String, String>
    ): UserResponseDto
}