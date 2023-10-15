package com.example.domain.use_cases.user

import com.example.domain.data_store.UserDataStoreRepository
import com.example.domain.models.user.UserCredentials

class SaveUserCredentialsUseCase constructor(
    private val repository: UserDataStoreRepository
) {

    suspend operator fun invoke(userCredentials: UserCredentials) {
        repository.saveUserCredentials(userCredentials = userCredentials)
    }
}