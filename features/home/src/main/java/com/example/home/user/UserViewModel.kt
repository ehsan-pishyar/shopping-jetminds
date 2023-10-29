package com.example.home.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.user.GetUserFromApiUseCase
import com.example.domain.use_cases.user.GetUserTokenUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserTokenUseCase: GetUserTokenUseCase,
    private val getUserFromApiUseCase: GetUserFromApiUseCase,
): ViewModel() {

    private var _userUiState = MutableStateFlow(MainUserUiState(UserUiState.Loading))
    val userUiState = _userUiState.asStateFlow()

    private var _userTokenUiState = MutableStateFlow("")
    val userTokenUiState = _userTokenUiState.asStateFlow()

    init {
        getUserTokenFromDataStore()
        getUserInformation()
    }

    private fun getUserInformation() {
        viewModelScope.launch {
            getUserFromApiUseCase.invoke(
                headers = mapOf(
                    "Authorization" to userTokenUiState.value
                )
            ).collect { userResult ->
                val userUiStateResult = when (userResult) {
                    ServiceResult.Loading -> UserUiState.Loading
                    is ServiceResult.Success -> UserUiState.Success(
                        user = userResult.data
                    )
                    is ServiceResult.Error -> UserUiState.Error(
                        throwable = userResult.throwable!!
                    )
                }
                _userUiState.value = MainUserUiState(
                    response = userUiStateResult
                )
            }
        }
    }

    private fun getUserTokenFromDataStore() {
        viewModelScope.launch {
            getUserTokenUseCase.invoke().collect { token ->
                _userTokenUiState.value = token
            }
        }
    }
}