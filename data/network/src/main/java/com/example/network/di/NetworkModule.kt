package com.example.network.di

import com.example.network.ApiService
import com.example.network.utils.Constants
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @[Provides Singleton]
    fun providesAuthQueryAppenderInterceptor(): Interceptor =
        Interceptor { chain ->
            val requestBuilder = chain.request().newBuilder()

            val url = chain.request().url
            val keyBuilder = url.newBuilder()
            if (url.queryParameter("consumer_key") == null) {
                keyBuilder.addQueryParameter(name = "consumer_key", value = Constants.CONSUMER_KEY)
                keyBuilder.addQueryParameter(name = "consumer_secret", value = Constants.CONSUMER_SECRET)
            }
            chain.proceed(
                requestBuilder
                    .url(keyBuilder.build())
                    .build()
            )
        }

    @[Provides Singleton]
    fun providesLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @[Provides Singleton]
    fun providesOkHttpsBuilder(
        authQueryAppenderInterceptor: Interceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(authQueryAppenderInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @[Provides Singleton]
    fun providesJson(): Json =
        Json { ignoreUnknownKeys = true }

    @[Provides Singleton]
    fun providesRetrofit(json: Json, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient)
            .build()

    @[Provides Singleton]
    fun providesApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}
