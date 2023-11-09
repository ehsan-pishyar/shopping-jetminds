package com.example.wordpress_network

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WordpressNetworkTest {

    private lateinit var server: MockWebServer
    private lateinit var api: UserApiService

    @Before
    fun setup() {
        server = MockWebServer()
        api = Retrofit.Builder()
            .baseUrl(WordpressConstants.WORDPRESS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(UserApiService::class.java)
    }

    @Test
    fun getUser() = runBlocking {

    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}