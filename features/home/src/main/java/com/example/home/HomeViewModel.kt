/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/11/23, 12:13 AM
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

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.utils.Categories
import com.example.core.utils.WhileUiSubscribed
import com.example.domain.use_cases.products.GetProductsUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getApplicationUiKitUseCase: GetProductsUseCase,
    getAndroidUseCase: GetProductsUseCase,
    getIllustrations3DUseCase: GetProductsUseCase
): ViewModel() {

    private val isRefreshing = MutableStateFlow(false)
    private val isError = MutableStateFlow(false)

    val homeUiState: StateFlow<HomeUiState> = combine(
        getApplicationUiKitUseCase.invoke(categoryId = Categories.APPLICATION_UI_KIT.id),
        getAndroidUseCase.invoke(categoryId = Categories.ANDROID.id),
        getIllustrations3DUseCase.invoke(categoryId = Categories.ILLUSTRATIONS_3D.id),
        isRefreshing,
        isError
    ) { applicationUiKitUiState, androidUiState, illustrations3DUiState, refreshing, errorConsumed ->

        val applicationUiKit: ApplicationUiKitUiState = when (applicationUiKitUiState) {
            ServiceResult.Loading -> ApplicationUiKitUiState.Loading
            is ServiceResult.Success -> ApplicationUiKitUiState.Success(
                applicationUiKits = applicationUiKitUiState.data
            )
            is ServiceResult.Error -> ApplicationUiKitUiState.Error(
                message = applicationUiKitUiState.throwable
            )
        }

        val androidSourceCodes: AndroidUiState = when (androidUiState) {
            ServiceResult.Loading -> AndroidUiState.Loading
            is ServiceResult.Success -> AndroidUiState.Success(
                androidSourceCodes = androidUiState.data
            )
            is ServiceResult.Error -> AndroidUiState.Error(
                message = androidUiState.throwable
            )
        }

        val illustration3Ds: Illustrations3DUiState = when (illustrations3DUiState) {
            ServiceResult.Loading -> Illustrations3DUiState.Loading
            is ServiceResult.Success -> Illustrations3DUiState.Success(
                illustration3Ds = illustrations3DUiState.data
            )
            is ServiceResult.Error -> Illustrations3DUiState.Error(
                message = illustrations3DUiState.throwable
            )
        }

        HomeUiState(
            applicationUiKit,
            androidSourceCodes,
            illustration3Ds,
            refreshing,
            errorConsumed
        )
    }
        .stateIn(
            scope = viewModelScope,
            started = WhileUiSubscribed,
            initialValue = HomeUiState(
                ApplicationUiKitUiState.Loading,
                AndroidUiState.Loading,
                Illustrations3DUiState.Loading,
                isRefreshing = false,
                isError = false
            )
        )

}

