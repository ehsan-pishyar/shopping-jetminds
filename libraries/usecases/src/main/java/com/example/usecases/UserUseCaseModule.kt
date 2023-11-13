/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/15/23, 9:50 PM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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