package com.example.domain.use_cases.user

import com.example.domain.data_store.UserDataStoreRepository
import kotlinx.coroutines.flow.Flow

class GetUserTokenUseCase constructor(
    private val repository: UserDataStoreRepository
) {
    operator fun invoke(): Flow<String> = repository.readUserToken()
}