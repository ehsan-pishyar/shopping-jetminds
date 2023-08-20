package com.example.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(

): ViewModel() {

    private var _accountUiState = MutableStateFlow(MainAccountUiState(AccountUiState.Loading))
    val accountUiState = _accountUiState.asStateFlow()

    fun getUser(userId: Int) {
        viewModelScope.launch {  }
    }
}