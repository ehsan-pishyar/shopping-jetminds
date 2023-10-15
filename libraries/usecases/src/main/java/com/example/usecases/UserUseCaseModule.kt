package com.example.usecases

import com.example.domain.data_store.UserDataStoreRepository
import com.example.domain.repositories.UserRepository
import com.example.domain.use_cases.user.GetUserCredentialsUseCase
import com.example.domain.use_cases.user.GetUserFromApiUseCase
import com.example.domain.use_cases.user.GetUserTokenFromApiUseCase
import com.example.domain.use_cases.user.GetUserTokenUseCase
import com.example.domain.use_cases.user.SaveUserCredentialsUseCase
import com.example.domain.use_cases.user.SaveUserTokenUseCase
import com.example.domain.use_cases.user.ValidateUserTokenUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UserUseCaseModule {

    @Provides
    fun providesSaveUserCredentialsUseCase(
        repository: UserDataStoreRepository
    ): SaveUserCredentialsUseCase = SaveUserCredentialsUseCase(repository = repository)

    @Provides
    fun providesGetUserCredentialsUseCase(
        repository: UserDataStoreRepository
    ): GetUserCredentialsUseCase = GetUserCredentialsUseCase(repository = repository)

    @Provides
    fun providesSaveUserTokenUseCase(
        repository: UserDataStoreRepository
    ): SaveUserTokenUseCase = SaveUserTokenUseCase(repository = repository)

    @Provides
    fun providesGetUserTokenUseCase(
        repository: UserDataStoreRepository
    ): GetUserTokenUseCase = GetUserTokenUseCase(repository = repository)

    @Provides
    fun providesGetUserTokenFromApiUseCase(
        repository: UserRepository
    ): GetUserTokenFromApiUseCase = GetUserTokenFromApiUseCase(repository = repository)

    @Provides
    fun providesValidateUserTokenUseCase(
        repository: UserRepository
    ): ValidateUserTokenUseCase = ValidateUserTokenUseCase(repository = repository)

    @Provides
    fun providesGetUserFromApiUseCase(
        repository: UserRepository
    ): GetUserFromApiUseCase = GetUserFromApiUseCase(repository = repository)
}