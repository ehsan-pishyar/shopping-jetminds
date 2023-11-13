/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/5/23, 12:10 PM
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

package com.example.domain.use_cases.user

import com.example.domain.models.user.TokenValidationResponse
import com.example.domain.repositories.UserRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asResult
import kotlinx.coroutines.flow.Flow

class ValidateUserTokenUseCase constructor(
    private val repository: UserRepository
) {

    operator fun invoke(): Flow<ServiceResult<TokenValidationResponse>> =
        repository.validateUserToken().asResult()
}