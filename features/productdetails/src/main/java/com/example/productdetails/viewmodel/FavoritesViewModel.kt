/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/1/23, 11:47 PM
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

package com.example.productdetails.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.favorites.IsFavoriteProductUseCase
import com.example.domain.use_cases.favorites.UpdateFavoriteProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val updateFavoriteProductUseCase: UpdateFavoriteProductUseCase,
    private val isFavoriteProductUseCase: IsFavoriteProductUseCase
): ViewModel() {

    private var _isFavoriteState = MutableStateFlow(false)
    val isFavoriteState = _isFavoriteState.asStateFlow()

    fun updateFavoriteProduct(productId: Int, isFavorite: Boolean) {
        viewModelScope.launch {
            updateFavoriteProductUseCase.invoke(productId = productId, isFavorite = isFavorite)
        }
    }

    fun isFavoriteProduct(productId: Int) {
        viewModelScope.launch {
            isFavoriteProductUseCase.invoke(productId = productId).collect {
                if (it != null) {
                    _isFavoriteState.value = it
                }
            }
        }
    }
}