package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ProductAttributesResponse
import com.example.domain.use_cases.product_attrs.GetProductAttrsUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface ProductAttrsUiState{
    object Loading: ProductAttrsUiState
    data class Success(val attrs: List<ProductAttributesResponse>): ProductAttrsUiState
    data class Error(val message: String): ProductAttrsUiState
}

data class HomeScreenProductAttrsUiState(
    val attrsUiState: ProductAttrsUiState
)

@HiltViewModel
class ProductAttributesViewModel @Inject constructor(
    private val getProductAttrsUseCase: GetProductAttrsUseCase
): ViewModel() {

    private var _attrsState = MutableStateFlow(HomeScreenProductAttrsUiState(ProductAttrsUiState.Loading))
    val attrsState = _attrsState.asStateFlow()

    init {
        getProductAttrs()
    }

    private fun getProductAttrs() {
        viewModelScope.launch {
            getProductAttrsUseCase.invoke().collect { attrsResult ->
                val attrsUiStateResult = when(attrsResult) {
                    ServiceResult.Loading -> ProductAttrsUiState.Loading
                    is ServiceResult.Success -> ProductAttrsUiState.Success(attrs = attrsResult.data)
                    is ServiceResult.Error -> ProductAttrsUiState.Error(message = attrsResult.throwable?.message!!)
                }
                _attrsState.value = HomeScreenProductAttrsUiState(attrsUiStateResult)
            }
        }
    }
}