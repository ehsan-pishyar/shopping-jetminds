/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 10/1/23, 11:47 PM
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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