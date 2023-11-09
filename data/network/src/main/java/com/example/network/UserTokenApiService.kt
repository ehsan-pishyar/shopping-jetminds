package com.example.network

import com.example.network.models.wordpress.UserTokenResponseDto
import retrofit2.http.POST
import retrofit2.http.Query

interface UserTokenApiService {

    @POST("token")
    suspend fun getUserToken(
        @Query("username") username: String,
        @Query("password") password: String
    ): UserTokenResponseDto
}