package com.example.wordpress_network

import com.example.wordpress_network.models.UserTokenResponseDto
import retrofit2.http.POST
import retrofit2.http.Query

interface UserTokenApiService {

    @POST("token")
    suspend fun getUserToken(
        @Query("username") username: String,
        @Query("password") password: String
    ): UserTokenResponseDto

}