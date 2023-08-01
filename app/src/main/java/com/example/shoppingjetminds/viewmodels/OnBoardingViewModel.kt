package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.data_store.SplashDataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val repository: SplashDataStoreRepository
): ViewModel() {

    fun saveOnBoardingState(completed: Boolean) {
        viewModelScope.launch(IO) {
            repository.saveOnBoardingState(completed = completed)
        }
    }
}