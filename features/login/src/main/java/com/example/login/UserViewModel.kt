package com.example.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.user.UserCredentials
import com.example.domain.use_cases.user.GetUserFromApiUseCase
import com.example.domain.use_cases.user.GetUserTokenFromApiUseCase
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
    private val getUserFromApiUseCase: GetUserFromApiUseCase
): ViewModel() {

    private var _tokenState = MutableStateFlow(MainUserTokenUiState(UserTokenUiState.Loading))
    val tokenState = _tokenState.asStateFlow()

    fun getUserToken(username: String, password: String) {
        viewModelScope.launch {
            getUserTokenFromApiUseCase.invoke(UserCredentials(
                username = username,
                password = password
            )).collect { tokenResult ->
                val userTokenUiStateResult = when (tokenResult) {
                    ServiceResult.Loading -> UserTokenUiState.Loading
                    is ServiceResult.Success -> UserTokenUiState.Success(
                        token = tokenResult.data
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
}