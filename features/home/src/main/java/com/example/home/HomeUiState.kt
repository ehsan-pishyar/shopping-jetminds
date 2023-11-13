/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 8/19/23, 10:25 PM
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

package com.example.home

import com.example.domain.models.ProductsResponse

data class HomeUiState(
    val applicationUiKitUiState: ApplicationUiKitUiState,
    val androidUiState: AndroidUiState,
    val illustrations3DUiState: Illustrations3DUiState,
    val isRefreshing: Boolean,
    val isError: Boolean
)

sealed interface ApplicationUiKitUiState {
    data class Success(val applicationUiKits: List<ProductsResponse>): ApplicationUiKitUiState
    data class Error(val message: Throwable? = null): ApplicationUiKitUiState
    object Loading: ApplicationUiKitUiState
}

sealed interface AndroidUiState {
    data class Success(val androidSourceCodes: List<ProductsResponse>): AndroidUiState
    data class Error(val message: Throwable? = null): AndroidUiState
    object Loading: AndroidUiState
}

sealed interface Illustrations3DUiState {
    data class Success(val illustration3Ds: List<ProductsResponse>): Illustrations3DUiState
    data class Error(val message: Throwable? = null): Illustrations3DUiState
    object Loading: Illustrations3DUiState
}