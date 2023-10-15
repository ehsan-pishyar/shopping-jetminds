package com.example.domain.use_cases.user

import com.example.domain.models.user.UserCredentials
import com.example.domain.models.user.UserTokenResponse
import com.example.domain.repositories.UserRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetUserTokenFromApiUseCase constructor(
    private val repository: UserRepository
) {

    operator fun invoke(userCredentials: UserCredentials): Flow<ServiceResult<UserTokenResponse>> =
        repository.getUserToken(userCredentials = userCredentials).asResult()
}