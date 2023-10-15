package com.example.wordpress_network

import com.example.wordpress_network.models.TokenValidationResponseDto
import com.example.wordpress_network.models.UserTokenResponseDto
import retrofit2.http.GET
import retrofit2.http.HeaderMap
import retrofit2.http.POST
import retrofit2.http.Query

interface UserTokenApiService {

    @POST("token")
    suspend fun getUserToken(
        @Query("username") username: String,
        @Query("password") password: String
    ): UserTokenResponseDto

    @GET("token-validate")
    suspend fun checkToken(
        @HeaderMap headers: Map<String, String>
    ): TokenValidationResponseDto
}