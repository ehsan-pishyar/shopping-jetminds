package com.example.shoppingjetminds.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.data_store.SplashDataStoreRepository
import com.example.shoppingjetminds.navigation.Graph
import com.example.shoppingjetminds.navigation.StartScreens
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