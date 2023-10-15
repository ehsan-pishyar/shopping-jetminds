package com.example.domain.use_cases.user

import com.example.domain.models.user.TokenValidationResponse
import com.example.domain.repositories.UserRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class ValidateUserTokenUseCase constructor(
    private val repository: UserRepository
) {

//    operator fun invoke(): Flow<ServiceResult<TokenValidationResponse>> =
//        repository.validateUserToken().asResult()
}