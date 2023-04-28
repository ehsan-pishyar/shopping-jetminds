package com.example.network.di

import com.example.network.ApiService
import com.example.network.utils.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideApi(): ApiService {
        val authQueryAppenderInterceptor = Interceptor { chain ->
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

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpBuilder = OkHttpClient.Builder()
            .addInterceptor(authQueryAppenderInterceptor)
            .addInterceptor(loggingInterceptor)

        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .client(okHttpBuilder.build())
                .build()
                .create(ApiService::class.java)
    }

//    @Singleton
//    @Provides
//    fun providesNetworkJson(): Json = Json {
//        ignoreUnknownKeys = true
//    }
//
//    @Singleton
//    @Provides
//    fun providesRetrofit(jsonConverter: Json): Retrofit =
//        Retrofit.Builder()
//            .baseUrl(Constants.BASE_URL)
//            .addConverterFactory(jsonConverter.asConverterFactory("application/json".toMediaType()))
//            .build()
//
//    @Singleton
//    @Provides
//    fun providesApiService(retrofit: Retrofit): ApiService =
//        retrofit.create(ApiService::class.java)
}
