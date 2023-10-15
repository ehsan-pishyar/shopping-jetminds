package com.example.domain.use_cases.user

import com.example.domain.data_store.UserDataStoreRepository
import com.example.domain.models.user.UserCredentials
import kotlinx.coroutines.flow.Flow

class GetUserCredentialsUseCase constructor(
    private val repository: UserDataStoreRepository
) {

    operator fun invoke(): Flow<UserCredentials> = repository.readUserCredentials()
}