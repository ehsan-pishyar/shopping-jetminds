/*
 * Copyright (c) 2023 JetMinds (Ehsan Pishyar)
 * Last Modified: 11/11/23, 1:26 AM
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
import com.example.domain.models.Cart
import com.example.domain.use_cases.cart.GetCartItemCountUseCase
import com.example.domain.use_cases.cart.GetCartTotalCountsUseCase
import com.example.domain.use_cases.cart.InsertCartItemUseCase
import com.example.domain.use_cases.cart.IsInCartItemUseCase
import com.example.domain.use_cases.cart.UpdateCartItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getCartItemCountUseCase: GetCartItemCountUseCase,
    private val insertCartItemUseCase: InsertCartItemUseCase,
    private val updateCartItemUseCase: UpdateCartItemUseCase,
    private val isInCartItemUseCase: IsInCartItemUseCase,
    private val getCartTotalCountsUseCase: GetCartTotalCountsUseCase
): ViewModel() {

    private var _cartItemCount = MutableStateFlow(0)
    val cartItemCount = _cartItemCount.asStateFlow()

    private var _isInCartUiState = MutableStateFlow(0)
    val isInCartUiState = _isInCartUiState.asStateFlow()

    private val _cartTotalCountState = MutableStateFlow(0)
    val cartTotalCountState = _cartTotalCountState.asStateFlow()

    init {
        getCartTotalCount()
    }

    fun getCartItemCount(productId: Int) {
        viewModelScope.launch {
            getCartItemCountUseCase.invoke(productId = productId).collect {
                it?.let { count ->
                    _cartItemCount.value = count
                }
            }
        }
    }

    fun insertCartItem(
        productId: Int,
        productTitle: String,
        productImage: String,
        productCategory: String,
        productPrice: Int,
        count: Int,
        dateAdded: String
    ) {
        viewModelScope.launch {
            insertCartItemUseCase.invoke(cartItem = Cart(
                productId = productId,
                productTitle = productTitle,
                productImage = productImage,
                productCategory = productCategory,
                productPrice = productPrice,
                dateAdded = dateAdded,
                itemCount = count
            ))
        }
    }

    fun updateCartItem(
        productId: Int,
        productPrice: Int,
        count: Int
    ) {
        viewModelScope.launch {
            updateCartItemUseCase.invoke(
                productId = productId,
                count = count,
                price = productPrice
            )
        }
    }

    fun isInCartItem(productId: Int) {
        viewModelScope.launch {
            isInCartItemUseCase.invoke(productId = productId).collect {
                _isInCartUiState.value = it!!
            }
        }
    }

    private fun getCartTotalCount() {
        viewModelScope.launch {
            getCartTotalCountsUseCase.invoke().collect {
                _cartTotalCountState.value = it!!
            }
        }
    }
}