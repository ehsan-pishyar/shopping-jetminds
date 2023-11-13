/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/9/23, 10:41 AM
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

package com.example.login

import com.example.domain.models.user.UserResponse

sealed interface WordpressUserUiState {
    object Loading: WordpressUserUiState
    data class Success (val wordpressUser: UserResponse): WordpressUserUiState
    data class Error (val throwable: Throwable): WordpressUserUiState
}

data class MainWordpressUserUiState(
    val response: WordpressUserUiState
)