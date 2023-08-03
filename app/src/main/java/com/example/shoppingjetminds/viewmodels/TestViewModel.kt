package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.products.GetProductsUseCase
import com.example.domain.utils.ServiceResult
import com.example.shoppingjetminds.uistates.AndroidUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class TestUiState(
    val testState: AndroidUiState
)

@HiltViewModel
class TestViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
): ViewModel() {

    private var _testState = MutableStateFlow(TestUiState(AndroidUiState.Loading))
    val testState = _testState.asStateFlow()

    init {
        getApplicationUiKits()
    }

    private fun getApplicationUiKits() {
        viewModelScope.launch {
            getProductsUseCase.invoke().collect {
                val testUiStateResult = when (it) {
                    ServiceResult.Loading -> AndroidUiState.Loading
                    is ServiceResult.Success -> AndroidUiState.Success(
                        androidSourceCodes = it.data
                    )
                    is ServiceResult.Error -> AndroidUiState.Error(
                        message = it.throwable
                    )
                }
                _testState.value = TestUiState(testState = testUiStateResult)
            }
        }
    }
}