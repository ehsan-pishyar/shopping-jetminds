package com.example.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.user.GetUserFromApiUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getUserFromApiUseCase: GetUserFromApiUseCase
): ViewModel() {

    private var _wordpressUserUiState = MutableStateFlow(
        MainWordpressUserUiState(WordpressUserUiState.Loading)
    )
    val wordpressUserUiState = _wordpressUserUiState.asStateFlow()

    fun getWordpressUser(token: String) {
        viewModelScope.launch {
            getUserFromApiUseCase.invoke(token = token).collect { wordpressUserResult ->
                val wordpressUserUiStateResult = when (wordpressUserResult) {
                    ServiceResult.Loading -> WordpressUserUiState.Loading.also {
                        println("*** ViewModel Loading ...")
                    }
                    is ServiceResult.Success -> WordpressUserUiState.Success(
                        wordpressUser = wordpressUserResult.data
                    ).also {
                        println("*** ViewModel Success")
                    }
                    is ServiceResult.Error -> WordpressUserUiState.Error(
                        throwable = wordpressUserResult.throwable!!
                    ).also {
                        println("*** ViewModel Error")
                    }
                }
                _wordpressUserUiState.value = MainWordpressUserUiState(
                    response = wordpressUserUiStateResult
                )
            }
        }
    }
}