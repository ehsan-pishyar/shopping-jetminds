package com.example.productdetails.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.products.GetProductDetailsUseCase
import com.example.domain.utils.ServiceResult
import com.example.productdetails.uistate.MainProductDetailsUiState
import com.example.productdetails.uistate.ProductDetailsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val getProductDetailsUseCase: GetProductDetailsUseCase
): ViewModel() {

    private var _productDetailsUiState = MutableStateFlow(
        MainProductDetailsUiState(
            ProductDetailsUiState.Loading
        )
    )
    val productDetailsUiState = _productDetailsUiState.asStateFlow()

    private var _productIdState = MutableStateFlow(0)
    val productIdState = _productIdState.asStateFlow()

    fun getProductDetails(productId: Int) {
        viewModelScope.launch {
            getProductDetailsUseCase.invoke(productId = productId).collect { productDetails ->
                val productDetailsUiStateResult = when (productDetails) {
                    ServiceResult.Loading -> ProductDetailsUiState.Loading
                    is ServiceResult.Success -> ProductDetailsUiState.Success(
                        productDetails = productDetails.data
                    )
                    is ServiceResult.Error -> ProductDetailsUiState.Error(
                        throwable = productDetails.throwable!!
                    )
                }

                _productDetailsUiState.value = MainProductDetailsUiState(
                    productDetailsUiState = productDetailsUiStateResult
                )
            }
        }
    }

    fun addProductId(productId: Int) {
        viewModelScope.launch {
            _productIdState.value = productId
        }
    }
}