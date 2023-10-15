package com.example.domain.use_cases.user

import com.example.domain.data_store.UserDataStoreRepository

class SaveUserTokenUseCase constructor(
    private val repository: UserDataStoreRepository
) {

    suspend operator fun invoke(token: String) = repository.saveUserToken(token = token)
}