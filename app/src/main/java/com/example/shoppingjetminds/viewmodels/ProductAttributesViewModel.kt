package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.ProductAttributesResponse
import com.example.domain.use_cases.product_attrs.GetProductAttrDetailsUseCase
import com.example.domain.use_cases.product_attrs.GetProductAttrsUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface ProductAttrsUiState {
    object Loading: ProductAttrsUiState
    data class Success(val attrs: List<ProductAttributesResponse>): ProductAttrsUiState
    data class Error(val message: String): ProductAttrsUiState
}

sealed interface ProductAttrDetailsUiState {
    object Loading: ProductAttrDetailsUiState
    data class Success(val attrDetails: ProductAttributesResponse): ProductAttrDetailsUiState
    data class Error(val message: String): ProductAttrDetailsUiState
}

data class MainProductAttrsUiState(
    val attrsUiState: ProductAttrsUiState
)

data class MainProductAttrDetailsUiState(
    val attrDetailsUiState: ProductAttrDetailsUiState
)

@HiltViewModel
class ProductAttributesViewModel @Inject constructor(
    private val getProductAttrsUseCase: GetProductAttrsUseCase,
    private val getProductAttrDetailsUseCase: GetProductAttrDetailsUseCase
): ViewModel() {

    private var _attrsState = MutableStateFlow(MainProductAttrsUiState(ProductAttrsUiState.Loading))
    val attrsState = _attrsState.asStateFlow()

    private var _attrDetailsState = MutableStateFlow(MainProductAttrDetailsUiState(ProductAttrDetailsUiState.Loading))
    val attrDetailsState = _attrDetailsState.asStateFlow()

    init {
        getProductAttrs()
    }

    private fun getProductAttrs() {
        viewModelScope.launch {
            getProductAttrsUseCase.invoke().collect { attrsResult ->
                val attrsUiStateResult = when (attrsResult) {
                    ServiceResult.Loading -> ProductAttrsUiState.Loading
                    is ServiceResult.Success -> ProductAttrsUiState.Success(attrs = attrsResult.data)
                    is ServiceResult.Error -> ProductAttrsUiState.Error(message = attrsResult.throwable?.message!!)
                }
                _attrsState.value = MainProductAttrsUiState(attrsUiStateResult)
            }
        }
    }

    fun getProductAttrDetails(attrId: Int) {
        viewModelScope.launch {
            getProductAttrDetailsUseCase.invoke(attrId = attrId).collect { attrDetailsResult ->
                val attrDetailsUiStateResult = when (attrDetailsResult) {
                    ServiceResult.Loading -> ProductAttrDetailsUiState.Loading
                    is ServiceResult.Success -> ProductAttrDetailsUiState.Success(
                        attrDetails = attrDetailsResult.data
                    )
                    is ServiceResult.Error -> ProductAttrDetailsUiState.Error(
                        message = attrDetailsResult.throwable?.message!!
                    )
                }
                _attrDetailsState.value = MainProductAttrDetailsUiState(attrDetailsUiStateResult)
            }
        }
    }
}