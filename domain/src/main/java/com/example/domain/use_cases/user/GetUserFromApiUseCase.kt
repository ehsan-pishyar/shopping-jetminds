package com.example.domain.use_cases.user

import com.example.domain.models.user.UserResponse
import com.example.domain.repositories.UserRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class GetUserFromApiUseCase constructor(
    private val repository: UserRepository
) {

    operator fun invoke(headers: Map<String, String>): Flow<ServiceResult<UserResponse>> =
        repository.getUser(headers = headers).asResult()
}