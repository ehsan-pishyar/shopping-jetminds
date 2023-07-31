package com.example.shoppingjetminds.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.product_attrs.GetProductAttrDetailsUseCase
import com.example.domain.use_cases.product_attrs.GetProductAttrsUseCase
import com.example.domain.utils.ServiceResult
import com.example.shoppingjetminds.uistates.MainProductAttrDetailsUiState
import com.example.shoppingjetminds.uistates.MainProductAttrsUiState
import com.example.shoppingjetminds.uistates.ProductAttrDetailsUiState
import com.example.shoppingjetminds.uistates.ProductAttrsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

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