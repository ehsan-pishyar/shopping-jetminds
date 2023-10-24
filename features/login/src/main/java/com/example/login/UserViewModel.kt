package com.example.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.user.UserCredentials
import com.example.domain.use_cases.user.GetUserTokenFromApiUseCase
import com.example.domain.use_cases.user.SaveUserTokenUseCase
import com.example.domain.use_cases.user.ValidateUserTokenUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserTokenFromApiUseCase: GetUserTokenFromApiUseCase,
    private val validateUserTokenUseCase: ValidateUserTokenUseCase,
    private val saveUserTokenUseCase: SaveUserTokenUseCase
): ViewModel() {

    private var _tokenState = MutableStateFlow(MainUserTokenUiState(UserTokenUiState.Loading))
    val tokenState = _tokenState.asStateFlow()

    private var _validateTokenState = MutableStateFlow(MainValidateTokenUiState(ValidateTokenUiState.Loading))
    val validateTokenUiState = _validateTokenState.asStateFlow()

    private var _dataStoreToken = MutableStateFlow("")

    fun getUserToken(username: String, password: String) {
        viewModelScope.launch {
            getUserTokenFromApiUseCase.invoke(UserCredentials(
                username = username,
                password = password
            )).collect { tokenResult ->
                val userTokenUiStateResult = when (tokenResult) {
                    ServiceResult.Loading -> UserTokenUiState.Loading
                    is ServiceResult.Success -> UserTokenUiState.Success(
                        userTokenResponse = tokenResult.data
                    )
                    is ServiceResult.Error -> UserTokenUiState.Error(
                        throwable = tokenResult.throwable!!
                    )
                }
                _tokenState.value = MainUserTokenUiState(
                    response = userTokenUiStateResult
                )
            }
        }
    }

    fun addTokenToDataStore(token: String) {
        viewModelScope.launch {
            _dataStoreToken.value = token
        }
    }

    fun validateToken(token: String) {
        viewModelScope.launch {
            validateUserTokenUseCase.invoke(headers = mapOf(
                "Authorization" to "Bearer $token"
            )).collect {
                val validateTokenUiStateResult = when (it) {
                    ServiceResult.Loading -> ValidateTokenUiState.Loading
                    is ServiceResult.Success -> ValidateTokenUiState.Success(
                        status = it.data
                    )
                    is ServiceResult.Error -> ValidateTokenUiState.Error(
                        throwable = it.throwable!!
                    )
                }

                _validateTokenState.value = MainValidateTokenUiState(
                    response = validateTokenUiStateResult
                )
            }
        }
    }

    fun saveTokenToDataStore(token: String) {
        viewModelScope.launch {
            saveUserTokenUseCase.invoke(token = token)
        }
    }
}