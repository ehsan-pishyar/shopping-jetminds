package com.example.network.di

import com.example.network.UserApiService
import com.example.network.UserTokenApiService
import com.example.network.utils.TokenQualifiers
import com.example.network.utils.WordpressConstants
import com.example.network.utils.WordpressQualifiers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyStore
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

@Module
@InstallIn(SingletonComponent::class)
object WordpressNetworkModule {


    @[Provides Singleton WordpressQualifiers]
    fun providesUserLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @[Provides Singleton WordpressQualifiers]
    fun providesUserOkHttpsBuilder(
        @WordpressQualifiers userLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(null as KeyStore?)

        // Create an SSLContext with the trust manager
        val sslContext = SSLContext.getInstance("TLS")
        sslContext.init(null, trustManagerFactory.trustManagers, null)

        return OkHttpClient.Builder()
            .addInterceptor(userLoggingInterceptor)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .sslSocketFactory(sslContext.socketFactory, trustManagerFactory.trustManagers[0] as X509TrustManager)
            .hostnameVerifier { _, _ -> true } // Accept all hostnames (disable hostname verification)
            .build()
    }

    @[Provides Singleton WordpressQualifiers]
    fun providesJson(): Json =
        Json { ignoreUnknownKeys = true }

    @[Provides Singleton TokenQualifiers]
    fun providesTokenRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(WordpressConstants.TOKEN_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @[Provides Singleton]
    fun providesTokenApiService(@TokenQualifiers retrofit: Retrofit): UserTokenApiService =
        retrofit.create(UserTokenApiService::class.java)

    @[Provides Singleton WordpressQualifiers]
    fun providesWordpressRetrofit(@WordpressQualifiers okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(WordpressConstants.WORDPRESS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @[Provides Singleton]
    fun providesWordpressApiService(@WordpressQualifiers retrofit: Retrofit): UserApiService =
        retrofit.create(UserApiService::class.java)
}