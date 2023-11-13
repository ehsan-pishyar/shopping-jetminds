/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/11/23, 8:11 PM
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

import com.example.domain.data_store.UserDataStoreRepository
import kotlinx.coroutines.flow.Flow

class GetUserTokenUseCase constructor(
    private val repository: UserDataStoreRepository
) {
    operator fun invoke(): Flow<String> = repository.readUserToken()
}