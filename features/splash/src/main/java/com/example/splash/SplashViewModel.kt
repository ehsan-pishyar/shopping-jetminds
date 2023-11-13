/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 8/15/23, 6:49 PM
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

package com.example.splash

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.data_store.SplashDataStoreRepository
import com.example.navigation.Graph
import com.example.navigation.StartScreens
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: SplashDataStoreRepository
): ViewModel() {

    private var _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private var _startDestination: MutableState<String> = mutableStateOf("")
    val startDestination: State<String> = _startDestination

    init {
        getOnBoardingState()
    }

    private fun getOnBoardingState() {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { completed ->
                if (completed) {
                    _startDestination.value = Graph.MAIN
                } else {
                    _startDestination.value = StartScreens.OnBoarding.route
                }
            }
        }
    }
}